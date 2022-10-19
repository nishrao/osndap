package io.osndap.tftp.protocol.packet;

public class TftpRRQPacket extends TftpRequest{

    @Override
    public TftpOpCode getOpCode() {
        return TftpOpCode.RRQ;
    }

}
