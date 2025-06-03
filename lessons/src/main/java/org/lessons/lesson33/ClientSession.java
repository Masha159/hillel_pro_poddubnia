package org.lessons.lesson33;

static class ClientSession implements Runnable{
    private final String clientName;
    private final String connectedAt;
    private final Socket socket;

    public ClientHandler(String clientName, String connectedAt, Socket socket) {
        this.clientName = clientName;
        this.connectedAt = connectedAt;
        this.socket = socket;
    }

}
