package com.example.springclientjdbc.datasource;

import java.util.HashMap;
import java.util.List;

public record Account(
        String id,
        String name,
        String email
) {
}
