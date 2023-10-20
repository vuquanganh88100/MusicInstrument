package software.vn.musicprj.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class UserDto {
    private Integer id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userSex;
    private Date userDate;
}
