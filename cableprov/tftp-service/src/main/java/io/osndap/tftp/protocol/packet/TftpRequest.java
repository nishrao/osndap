package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter @Setter
public abstract class TftpRequest extends TftpPacket{
    private String fileName;
    private TftpMode mode;
    private List<TftpOptionExtension> tftpOptions = new ArrayList<>();
}
