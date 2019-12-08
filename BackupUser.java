/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backups;

/**
 *
 * @author Owner
 */
public class BackupUser {
    private String email;
    private String username;
    private String password;
    
    public BackupUser(String _email, String _username, String _password) {
        this.email = _email;
        this.username = _username;
        this.password = _password;
    }
    
    // ====== SETTERS ======//
    public void setEmail(String _email) {
        this.email = _email;
    }

    public void setUsername(String _username) {
        this.username = _username;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    // ====== GETTERS ======//
    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    
    
}
