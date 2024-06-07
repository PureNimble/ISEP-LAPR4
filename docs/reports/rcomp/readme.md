<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# RCOMP Application Protocol

## Table of Contents

- [Introduction](#1-introduction)
- [Message Format](#2-message-format)
- [Message Codes](#3-message-codes)
  - [Message Handlers](#31-message-handlers)
    - [COMMTEST](#311-commtest)
    - [DISCONN](#312-disconn)
    - [AUTH](#313-auth)
    - [LOGOUT](#314-logout)
    - [CHANGEPASS](#315-changepass)
    - [LISTAPPREQ](#316-listappreq)
    - [LISTJOBREQ](#317-listjobreq)
    - [H2](#318-h2)
    - [NOTIFICATION](#319-notification)

## 1. Introduction

This document describes the RCOMP part of the project related to the application protocol.

The RCOMP application protocol is a communication protocol that defines the format of messages exchanged between the client and server applications. The protocol is designed to be used over a TCP connection, and it is intended to be used in the context of a job recruitment application.

- Client initiates TCP connection with server using server's IP/DNS and TCP port number.
- Once connected, applications exchange messages as per specified format.
- TCP connection remains open for all data exchanges while client is running.
- Communication follows strict client-server pattern: one request from client, one response from server.

## 2. Message Format

The communication protocol message format is described in the following table:

<table>
    <tr>
        <th style="text-align: center;">Field</th>
        <th style="text-align: center;">Offset (bytes)</th>
        <th style="text-align: center;">Length (bytes)</th>
        <th style="text-align: center;">Description</th>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Version</strong></td>
        <td style="text-align: center;">0</td>
        <td style="text-align: center;">1</td>
        <td>Message format version. This field is a single byte and should be interpreted as an unsigned integer (value 0 to 255). The present message format version number is one.</td>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Code</strong></td>
        <td style="text-align: center;">1</td>
        <td style="text-align: center;">1</td>
        <td>This field identifies the type of request or response, it should be interpreted as an unsigned integer (value 0 to 255). <a href="#3-message-codes"><em><strong>See Section 3.</strong></em></a></td>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Data1_Len_L</strong></td>
        <td style="text-align: center;">2</td>
        <td style="text-align: center;">1</td>
        <td rowspan="2">These two fields are used to specify the length in bytes of the following DATA1 field. Both these fields are to be interpreted as unsigned integer numbers (value 0 to 255).
        The length of the DATA1 field is to be calculated as:
        DATA1_LEN_L + 256 x DATA1_LEN_M
        If the resulting value is zero, it means DATA1 does not exist, and the message has ended at this point.</td>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Data1_Len_M</strong></td>
        <td style="text-align: center;">3</td>
        <td style="text-align: center;">1</td>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Data1</strong></td>
        <td style="text-align: center;">4</td>
        <td style="text-align: center;">-</td>
        <td>First chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message’s code (type of request or response).</td>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Data2_Len_L</strong></td>
        <td style="text-align: center;">-</td>
        <td style="text-align: center;">1</td>
        <td rowspan="2">These two fields are used to specify the length in bytes of the following DATA2 field. Both these fields are to be interpreted as unsigned integer numbers (value 0 to 255).
        The length of the DATA2 field is to be calculated as:
        DATA2_LEN_L + 256 x DATA2_LEN_M
        If the resulting value is zero, it means DATA2 does not exist, and the message has ended at this point.</td>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Data2_Len_M</strong></td>
        <td style="text-align: center;">-</td>
        <td style="text-align: center;">1</td>
    </tr>
    <tr>
        <td style="text-align: center;"><strong>Data2</strong></td>
        <td style="text-align: center;">-</td>
        <td style="text-align: center;">-</td>
        <td>Second chunk of data, contains data to meet the specific needs of the participating applications, its existence and the content depend on the message’s code (type of request or response).</td>
    </tr>
</table>

The message format is implemented in the `ProtocolMessage` class, which provides methods to convert the message to a byte stream and extract the data chunks.

```java
public byte[] toByteStream() throws IOException {

    ByteArrayOutputStream result = new ByteArrayOutputStream();
    result.write(protocolVersion);
    result.write(code.toByte());

    for (byte[] data : dataChunks) {
        if (data != null) {
            result.write(data.length % 256);
            result.write(data.length / 256);
            result.write(data);
        } else {
            result.write(0);
            result.write(0);
        }
    }

    result.write(0);
    result.write(0);

    return result.toByteArray();
}
```

## 3. Message Codes

The protocol defines specific codes for different types of requests and responses between the client and server. Each code corresponds to a particular type of message and determines the data structure and content.

| CODE | Type     | Meaning |
|:----:|:--------:|---------|
| **0**    | **Request** | **COMMTEST** – Communications test request with no other effect on the server application than the response with an ACK message. This request has no data. _[**See Section 3.1.1.**](#311-commtest)_ |
| **1**    | **Request**  | **DISCONN** – End of session request. The server application is supposed to respond with an ACK message, afterwards both client and server applications are expected to close the session (TCP connection). This request has no data. _[**See Section 3.1.2.**](#312-disconn)_ |
| **2**    | **Response** | **ACK** – Generic acknowledgment and success response message. Used in response to a successful request. This response contains no data. |
| **3**    | **Response** | **ERR** – Error response message. Used in response to unsuccessful requests that caused an error. This response message may carry a human readable phrase explaining the error. If used, the phrase is carried in the DATA1 field as string of ASICII codes, it’s not required to be null terminated. |
| **4**   | **Request**  | **AUTH** – User authentication request carrying the username in DATA1 and the user’s password in DATA2, both are strings of ASICII codes and are not required to be null terminated. If the authentication is successful, the server application response is ACK, otherwise it’s ERR. _[**See Section 3.1.3.**](#313-auth)_ |
| **5**   | **Request**  | **LOGOUT** – User logout request. This request has no data. If the logout is successful, the server application response is ACK, otherwise it’s ERR. _[**See Section 3.1.4.**](#314-logout)_ |
| **6**   | **Request**  | **CHANGEPASS** – User password change request carrying the old password in DATA1 and the new password in DATA2, both are strings of ASICII codes and are not required to be null terminated. If the password change is successful, the server application response is ACK, otherwise it’s ERR. _[**See Section 3.1.5.**](#315-changepass)_ |
| **7**   | **Request**  | **LISTAPPREQ** – List applications request. This request has no data. The server application response is a list of applications available to the user, their state and the number of applicants. The response is a list of strings of ASICII codes, each string is not required to be null terminated. _[**See Section 3.1.6.**](#316-listappreq)_ |
| **8**   | **Response**  | **LISTAPPRES** – List applications response. This response carries the list of applications available to the user, their state and the number of applicants. The response is a list of strings of ASICII codes, each string is not required to be null terminated. |
| **9**   | **Request**  | **LISTJOBREQ** – List jobs openings request. This request has no data. The server application response is a list of job openings associated to that user, including job reference, position, active since, number of applicants. The response is a list of strings of ASICII codes, each string is not required to be null terminated. _[**See Section 3.1.7.**](#317-listjobreq)_ |
| **10**  | **Response**  | **LISTJOBRES** – List jobs openings response. This response carries the list of job openings associated to that user, including job reference, position, active since, number of applicants. The response is a list of strings of ASICII codes, each string is not required to be null terminated. |
| **11**  | **Notification**  | **H2** – This is a change detection notification that the server receives from the H2 database. The notification is triggered when changes are detected in certain tables. The notification contains the user’s email and the type of change. _[**See Section 3.1.8.**](#318-h2)_ |
| **12**  | **Notification**  | **NOTIFICATION** – Server sends this notification each time it detects a change of interest to the user. The notification carries information about the changes. _[**See Section 3.1.9.**](#319-notification)_ |


### 3.1. Message Handlers

The message handlers are responsible for processing incoming messages based on their type and executing the appropriate logic. The message handlers are implemented as classes that extend the abstract class `Message` and implement the `handle` method.

```java
public abstract class Message {

    protected final ProtocolMessage request;
    protected final EventListener eventListener;
    protected final Socket socket;
    protected final DataOutputStream output;

    public Message(final ProtocolMessage message, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        this.request = message;
        this.output = output;
        this.socket = socket;
        this.eventListener = eventListener;
    }

    public abstract void handle() throws IOException;

    public void send(final ProtocolMessage response) throws IOException {
        synchronized (output) {
            output.write(response.toByteStream());
        }
    }

    public void close() throws IOException {
        output.close();
        socket.close();
    }
}
```

#### 3.1.1. COMMTEST

Handles communication test requests by sending an ACK response.

```java
public class CommTestMessage extends Message {
    public CommTestMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {
        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
    }
}
```

#### 3.1.2. DISCONN

Handles disconnection requests by sending an ACK response and closing the connection.

```java
public class DisconnMessage extends Message {
    public DisconnMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {
        eventListener.removeClient(socket);
        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
        close();
    }
}
```

#### 3.1.3. AUTH

Handles authentication requests by verifying user credentials and sending an ACK or ERR response.

```java
public class AuthMessage extends Message {

    public AuthMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final AuthenticationCredentialHandler credentialHandler = new AuthenticationCredentialHandler();
        final UserManagementService userSvc = AuthzRegistry.userService();
        final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

        final byte[][] dataChunks = request.datachunks();

        if (dataChunks.length < 3) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR), output, socket, eventListener).handle();
            return;
        }

        final String usernameStr = new String(dataChunks[0], StandardCharsets.US_ASCII);
        final String passwordStr = new String(dataChunks[1], StandardCharsets.US_ASCII);
        final String role = new String(dataChunks[2], StandardCharsets.US_ASCII);

        if (!credentialHandler.authenticated(usernameStr, passwordStr, Role.valueOf(role))) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Wrong credentials!"));
            return;
        }

        final Optional<SystemUser> optional = userSvc.userOfIdentity(Username.valueOf(usernameStr));

        if (!optional.isPresent()) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Wrong credentials!"));
            return;
        }

        send(new ProtocolMessage((byte) 1, MessageCode.ACK));

        eventListener.addClient(optional.get(), socket);
        authorizationService.clearSession();
    }
}
```

#### 3.1.4. LOGOUT

Handles logout requests by removing the client and sending an ACK response.

```java
public class LogoutMessage extends Message {

    public LogoutMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {
        eventListener.removeClient(socket);
        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
    }
}
```

#### 3.1.5. CHANGEPASS

Handles password change requests by verifying the old password and updating it with the new one.

```java
public class ChangePassMessage extends Message {

    public ChangePassMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final AuthenticationCredentialHandler credentialHandler = new AuthenticationCredentialHandler();
        final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
        final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

        final byte[][] dataChunks = request.datachunks();
        if (dataChunks.length < 2) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Bad Request"), output, socket,
                    eventListener).handle();
            return;
        }
        final Optional<SystemUser> userOpt = eventListener.user(socket);
        if (userOpt.isEmpty()) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Something went wrong"), output, socket,
                    eventListener).handle();
            return;
        }
        final SystemUser user = userOpt.get();
        final String oldPassword = new String(dataChunks[0], StandardCharsets.US_ASCII);
        final String newPassword = new String(dataChunks[1], StandardCharsets.US_ASCII);

        if (!credentialHandler.authenticated(user.username().toString(), oldPassword,
                user.roleTypes().stream().findFirst().get())) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid authentication"));
            return;
        }

        try {
            if (!authenticationService.changePassword(oldPassword, newPassword)) {
                send(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid authentication"));
                return;
            }
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "An error has occurred"));
        }

        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
        authorizationService.clearSession();
    }
}
```

#### 3.1.6. LISTAPPREQ

Handles list applications requests by retrieving the applications available to the user and sending a response with the list.

```java
public class ListAppReqMessage extends Message {

    public ListAppReqMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final ListCandidateApplicationsService listCandidateApplicationsService = new ListCandidateApplicationsService(
                PersistenceContext.repositories().applications(), PersistenceContext.repositories().candidates());

        final Optional<SystemUser> userOpt = eventListener.user(socket);
        if (userOpt.isEmpty()) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Something went wrong"), output, socket,
                    eventListener).handle();
            return;
        }
        final SystemUser user = userOpt.get();

        if (!user.hasAny(BaseRoles.CANDIDATE)) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid Authentication"), output, socket,
                    eventListener).handle();
            return;
        }

        final Iterable<ApplicationDTO> applications = listCandidateApplicationsService
                .findApplicationsFromCandidate(user.email());

        final int size = (int) StreamSupport.stream(applications.spliterator(), false).count();

        List<String> data = new ArrayList<>();
        data.add(Integer.toString(size));
        for (final ApplicationDTO application : applications) {
            data.add(application.getApplicationCode());
            data.add(application.getStatus());
            data.add(listCandidateApplicationsService.numApplicants(application).toString());
        }

        send(new ProtocolMessage((byte) 1, MessageCode.LISTAPPRES, data.toArray(new String[0])));
    }
}
```

#### 3.1.7. LISTJOBREQ

Handles list job openings requests by retrieving the job openings available to the user and sending a response with the list.

```java
public class ListJobReqMessage extends Message {

    public ListJobReqMessage(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final ListJobOpeningsService listJobOpeningsService = new ListJobOpeningsService(
                PersistenceContext.repositories().jobOpenings(), PersistenceContext.repositories().customers(),
                PersistenceContext.repositories().applications());

        final Optional<SystemUser> userOpt = eventListener.user(socket);
        if (userOpt.isEmpty()) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Something went wrong"), output, socket,
                    eventListener).handle();
            return;
        }
        final SystemUser user = userOpt.get();

        if (!user.hasAny(BaseRoles.CUSTOMER)) {
            new ErrMessage(new ProtocolMessage((byte) 1, MessageCode.ERR, "Invalid Authentication"), output, socket,
                    eventListener).handle();
            return;
        }

        final Iterable<JobOpeningDTO> jobOpenings = listJobOpeningsService
                .findJobOpeningsFromCustomer(user.email());

        final int size = (int) StreamSupport.stream(jobOpenings.spliterator(), false).count();

        List<String> data = new ArrayList<>();
        data.add(Integer.toString(size));
        for (final JobOpeningDTO jobOpeningDTO : jobOpenings) {
            data.add(jobOpeningDTO.getJobReference());
            data.add(jobOpeningDTO.getTitleOrFunction());
            data.add(jobOpeningDTO.getActiveSince());
            data.add(listJobOpeningsService.numApplicants(jobOpeningDTO).toString());
        }

        send(new ProtocolMessage((byte) 1, MessageCode.LISTJOBRES, data.toArray(new String[0])));
    }
}
```

#### 3.1.8. H2

Handles H2 notifications by adding notifications to a queue for the user.

```java
public class H2Message extends Message {

    public H2Message(final ProtocolMessage protocolMessage, final DataOutputStream output, final Socket socket,
            final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        final ListUsersController listUsersController = new ListUsersController(
                PersistenceContext.repositories().users());

        final byte[][] dataChunks = request.datachunks();

        final String username = new String(dataChunks[0], StandardCharsets.UTF_8);

        final Optional<SystemUser> user = listUsersController.find(Username.valueOf(username));

        if (!user.isPresent())
            send(new ProtocolMessage((byte) 1, MessageCode.ERR, "User not found"));

        byte[][] message = Arrays.copyOfRange(dataChunks, 1, dataChunks.length);
        final SystemUser systemUser = user.get();

        eventListener.addNotification(systemUser, new ProtocolMessage((byte) 1, MessageCode.NOTIFICATION, message));

        send(new ProtocolMessage((byte) 1, MessageCode.ACK));
    }
}
```

#### 3.1.9. NOTIFICATION

Handles notification messages by sending notifications to the user.

```java
public class NotificationMessage extends Message {

    public NotificationMessage(final ProtocolMessage protocolMessage, final DataOutputStream output,
            final Socket socket, final EventListener eventListener) {
        super(protocolMessage, output, socket, eventListener);
    }

    @Override
    public void handle() throws IOException {

        eventListener.user(socket).ifPresent(user -> {
            eventListener.notifications(user).ifPresent(notifications -> {
                notifications.forEach(notification -> {
                    try {
                        send(notification);
                        eventListener.removeNotification(user, notification);
                    } catch (final Exception e) {
                        return;
                    }
                });
            });
        });

    }
}
```

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>