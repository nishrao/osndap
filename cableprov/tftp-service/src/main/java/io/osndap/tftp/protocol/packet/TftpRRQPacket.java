package io.osndap.tftp.protocol.packet;

public class TftpRRQPacket extends TftpRequestPacket {

    @Override
    public TftpOpCode getOpCode() {
        return TftpOpCode.RRQ;
    }

}
