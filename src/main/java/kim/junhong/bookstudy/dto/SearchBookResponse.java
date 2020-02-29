package kim.junhong.bookstudy.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SearchBookResponse {

    Map<String, Object> meta;
    List<Map<String, Object>> documents;
}
