package io.osndap.tftp.protocol.packet;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter @Setter
public abstract class TftpRequestPacket extends TftpPacket{
    private String fileName;
    private TftpMode mode;
    private List<TftpOptionExtension> tftpOptions = new ArrayList<>();

    @Override
    public void decode(@NonNull ByteBuffer buffer) {
        //RFC 1350 TFTP Protocol
        setFileName(decodeString(buffer));
        setMode(TftpMode.forMode(decodeString(buffer)));

         // Read all the tftp options
         // RFC 2347 Option Extension
         // RFC 2348 TFTP Block Size Option
         // RFC 2349 TFTP Interval and Transfer Size Options

        while(buffer.hasRemaining()) {
            TftpOptionType optionType = TftpOptionType.forOpType(decodeString(buffer));
            switch(optionType) {
                case blksize:
                    TftpBlkSizeOptionExtension blkSizeOptionExtension =
                            new TftpBlkSizeOptionExtension(TftpOptionType.blksize, Integer.parseInt(decodeString(buffer)));
                    tftpOptions.add(blkSizeOptionExtension);
                    break;
                case tsize:
                    //TODO: Need to implement the tsize
                    break;
                case timeout:
                    //TODO: Need to implement the timout
            }
        }
    }
}
