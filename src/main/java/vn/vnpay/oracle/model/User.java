package vn.vnpay.oracle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private String fullname;

    private String phone;

    private String email;

    public void convertUser(Map map) {
        setId(Long.parseLong(map.get("N_ID").toString()));
        setUsername(map.get("S_USERNAME") == null ? " " : map.get("S_USERNAME").toString());
        setFullname(map.get("S_FULLNAME") == null ? " " : map.get("S_FULLNAME").toString());
        setPhone(map.get("S_ADDRESS") == null ? " " : map.get("S_ADDRESS").toString());
    }
}
