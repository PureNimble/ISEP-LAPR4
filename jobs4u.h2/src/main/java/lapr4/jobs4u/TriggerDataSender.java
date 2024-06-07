package lapr4.jobs4u;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.h2.api.Trigger;

import lapr4.jobs4u.protocol.MessageCode;
import lapr4.jobs4u.protocol.ProtocolMessage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 2DI2
 */
public class TriggerDataSender implements Trigger {

    private String tableName;

    @Override
    public void init(final Connection conn, final String schemaName, final String triggerName, String tableName,
            final boolean before, final int type) {

        this.tableName = tableName;
    }

    @Override
    public void fire(final Connection conn, final Object[] oldRow, final Object[] newRow) {
        sendToServer(switch (tableName) {
        default -> checkState(oldRow, newRow, conn);
        case "T_RESULT" -> checkResult(oldRow, newRow, conn);
        case "T_REQUIREMENT" -> checkRequirements(oldRow, newRow, conn);
        case "T_APPLICATION" -> checkNewApplication(newRow);
        });

    }

    private List<String> checkState(final Object[] oldRow, final Object[] newRow, final Connection conn) {
        final String oldStatus = oldRow[3].toString();
        final String newStatus = newRow[3].toString();
        final String id = oldRow[2].toString();

        List<String> data = new ArrayList<>();
        String temp = tableName.replace("T_", "").replace("_", "") + "_PK";

        final String query = "SELECT CC.ACCOUNT_EMAIL FROM T_RECRUITMENT_PROCESS RP, T_JOB_OPENING JO, T_CUSTOMER_USER CC WHERE  RP."
                + temp
                + " = ? AND RP.JOBOPENING_JOBREFERENCE = JO.JOBREFERENCE AND JO.CUSTOMER_CODE = CC.CUSTOMER_CODE ;";

        String email = query(conn, id, query, "ACCOUNT_EMAIL");
        if (email == null || oldStatus.equals(newStatus))
            return data;

        String output = "[" + tableName.replace("T_", "") + "] Status changed from " + oldStatus + " to " + newStatus;
        data.add(email);
        data.add(output);

        return data;

    }

    private List<String> checkResult(final Object[] oldRow, final Object[] newRow, final Connection conn) {
        final String oldResult = oldRow[1].toString();
        final String newResult = newRow[1].toString();
        final String newText = newRow[2] != null ? newRow[2].toString() : null;
        final String id = newRow[0].toString();
        String output;
        List<String> data = new ArrayList<>();

        String query1 = "SELECT CANDIDATE FROM T_APPLICATION WHERE RESULT_PK = ?;";
        String query2 = "SELECT JOBOPENING FROM T_APPLICATION WHERE RESULT_PK = ?;";
        String email = query(conn, id, query1, "CANDIDATE");
        String jobOpening = query(conn, id, query2, "JOBOPENING");

        if (jobOpening == null || email == null || oldResult.equals(newResult))
            return data;

        output = "Job Opening[" + jobOpening + "]Result changed from " + oldResult + " to " + newResult;

        if (newText != null)
            output += " with the following justification: " + newText;

        data.add(email);
        data.add(output);
        return data;

    }

    private List<String> checkRequirements(final Object[] oldRow, final Object[] newRow, final Connection conn) {
        final String applicationCode = newRow[2].toString();
        final String oldResult = oldRow[3].toString();
        final String newResult = newRow[3].toString();
        final String newText = newRow[5] != null ? newRow[4].toString() : null;
        List<String> data = new ArrayList<>();

        final String query = "SELECT CANDIDATE FROM T_APPLICATION WHERE NUMBER = ?;";

        String email = query(conn, applicationCode, query, "CANDIDATE");

        if (email == null || oldResult.equals(newResult))
            return data;

        String output = "Application[" + applicationCode + "] Requirement changed from " + oldResult + " to "
                + newResult;

        if (newText != null)
            output += " with the following justification: " + newText;

        data.add(email);
        data.add(output);

        return data;

    }

    private List<String> checkNewApplication(final Object[] newRow) {
        final String email = newRow[3].toString();
        final String jobOpening = newRow[4].toString();
        final String output = "Your application for Job Opening[" + jobOpening + "] was submitted.";
        List<String> data = new ArrayList<>();
        data.add(email);
        data.add(output);

        return data;
    }

    private String query(final Connection conn, final String id, final String query, final String column) {

        String outcome = null;
        try (final PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);

            try (final ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    outcome = rs.getString(column);
                }
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return outcome;
    }

    private void sendToServer(final List<String> data) {
        if (data.isEmpty())
            return;
        for (final String s : data) {
            System.out.println(s);
        }
        ProtocolMessage message;
        try {
            final TcpH2 tcpH2 = new TcpH2();
            message = new ProtocolMessage((byte) 1, MessageCode.H2, data.toArray(new String[0]));
            final ProtocolMessage response = tcpH2.sendRecv(message);
            if (response != null) {
                System.out.println(response.toString());
            }
            tcpH2.disconnect();

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
    }

    @Override
    public void remove() {
    }
}