//package software.vn.musicprj.utils;
//
//import software.vn.musicprj.dto.ListDto;
//import software.vn.musicprj.entities.ListMusicEntity;
//
//import java.io.IOException;
//
//public class ListDtoToListMusicEntityConverter {
//    public static ListMusicEntity convert(ListDto listDto) {
//        ListMusicEntity listMusicEntity = new ListMusicEntity();
//        listMusicEntity.setId(listDto.getId());
//        listMusicEntity.setInstrumentName(listDto.getInstrumentName());
//        listMusicEntity.setMusicType(listDto.getMusicType());
//
//        if (listDto.getAudio() != null && !listDto.getAudio().isEmpty()) {
//            try {
//                byte[] audioBytes = listDto.getAudio().getBytes();
//                listMusicEntity.setAudio(audioBytes);
//            } catch (IOException e) {
//                // handle the error as appropriate for your application
//                throw new RuntimeException("Failed to read audio file", e);
//            }
//        }
//
//        return listMusicEntity;
//    }
//}
