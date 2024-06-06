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
    private Integer triggerType;

    @Override
    public void init(final Connection conn, final String schemaName, final String triggerName, String tableName,
            final boolean before, final int type) {

        triggerType = switch (tableName) {
            default -> 1;
            case "T_RESULT" -> 2;
            case "T_REQUIREMENT" -> 3;
            case "T_APPLICATION" -> 4;
        };

        this.tableName = tableName;
    }

    @Override
    public void fire(final Connection conn, final Object[] oldRow, final Object[] newRow) {
        sendToServer(switch (triggerType) {
            case 1 -> checkState(oldRow, newRow, conn);
            case 2 -> checkResult(oldRow, newRow, conn);
            case 3 -> checkRequirements(oldRow, newRow, conn);
            case 4 -> checkNewApplication(newRow);
            default -> throw new IllegalArgumentException("Invalid trigger type: " + triggerType);
        });

    }

    private List<String> checkState(final Object[] oldRow, final Object[] newRow, final Connection conn) {
        final String oldStatus = oldRow[3].toString();
        final String newStatus = newRow[3].toString();
        final String id = oldRow[2].toString();

        List<String> data = new ArrayList<>();

        if (!oldStatus.equals(newStatus)) {
            data.add(oldStatus);
            data.add(newStatus);
            String temp = getJobOpeningReference(conn, id);
            if (temp != null) {
                data.add(temp);
            }
        }

        return data;

    }

    private List<String> checkResult(final Object[] oldRow, final Object[] newRow, final Connection conn) {
        final String oldResult = oldRow[1].toString();
        final String newResult = newRow[1].toString();
        final String oldText = oldRow[2] != null ? oldRow[2].toString() : null;
        final String newText = newRow[2] != null ? newRow[2].toString() : null;
        final String id = oldRow[0].toString();
        List<String> data = new ArrayList<>();
        if (!oldResult.equals(newResult)) {
            data.add(oldResult);
            data.add(newResult);
            if (!oldText.equals(newText)) {
                data.add(oldText);
                data.add(newText);
            }
            String temp = getAplication(conn, id);
            if (temp != null) {
                data.add(temp);
            }
        }
        return data;
    }

    private List<String> checkRequirements(final Object[] oldRow, final Object[] newRow, final Connection conn) {
        final String ApplicationCode = newRow[2].toString();
        final String oldResult = oldRow[3].toString();
        final String newResult = newRow[3].toString();
        final String oldText = oldRow[5] != null ? oldRow[4].toString() : null;
        final String newText = newRow[5] != null ? newRow[4].toString() : null;

        System.out.println("\nApplicationCode: " + ApplicationCode);
        System.out.println("Old result: " + oldResult);
        System.out.println("New result: " + newResult);
        System.out.println("Old text: " + oldText);
        System.out.println("New text: " + newText);
        System.out.println("Table name: " + tableName);
        return null;

    }

    private List<String> checkNewApplication(final Object[] newRow) {
        String email = newRow[3].toString();
        System.out.println("\nEmail: " + email);
        return null;
    }

    private String getJobOpeningReference(final Connection conn, final String id) {
        String jobOpening = null;
        tableName = tableName.replace("T_", "").replace("_", "") + "_PK";
        final String query = "SELECT JOBOPENING_JOBREFERENCE FROM T_RECRUITMENT_PROCESS WHERE " + tableName + " = ?";

        try (final PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);

            try (final ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    jobOpening = rs.getString("JOBOPENING_JOBREFERENCE");
                }
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return jobOpening;
    }

    private String getAplication(final Connection conn, final String id) {
        String application = null;
        final String query = "SELECT NUMBER FROM T_APPLICATION WHERE RESULT_PK = ?;";
        try (final PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, id);

            try (final ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    application = rs.getString("NUMBER");
                }
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return application;
    }

    private void sendToServer(final List<String> data) {
        if (data.isEmpty())
            return;
        ProtocolMessage message;
        try {
            message = new ProtocolMessage((byte) 1, MessageCode.H2, data.toArray(new String[0]));
            TcpH2.sendRecv(message);
            TcpH2.disconnect();

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