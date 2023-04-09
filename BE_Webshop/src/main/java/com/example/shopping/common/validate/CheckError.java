package com.example.shopping.common.validate;

import java.util.HashMap;

public class CheckError extends HashMap<String, String> {
    private static final long serialVersionUID = 1L;

	private CheckError() {
    
    }
    
    public static CheckError get() {
        return new CheckError();
    }
    
    public boolean isPass() {
        return this.size() == 0;
    }
    
    public String getFirstErrorMessage() {
        if (keySet().isEmpty()) {
            return "";
        } else {
            return get(keySet().toArray()[0]);
        }
    }
    
    public String getError() {
        return get("ERROR");
    }
    
    public String[] getAllErrorMessage() {
        return values().toArray(new String[]{});
    }
    
    public CheckError putError(String message) {
        put("ERROR", message);
        return this;
    }
}
