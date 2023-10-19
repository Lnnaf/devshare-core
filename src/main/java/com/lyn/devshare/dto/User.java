package com.lyn.devshare.dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
     Long id;
     String name;
}
