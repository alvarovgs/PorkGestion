package com.example.a201495_2.porkgestion;

import android.app.Application;
import com.example.a201495_2.porkgestion.bo_clases.Usuario;

public class GlobalClass extends Application {

    private Usuario ActiveUser;

    public GlobalClass(Usuario activeUser) {
        ActiveUser = activeUser;
    }
    public GlobalClass() {

    }
    public Usuario getActiveUser() {
        return ActiveUser;
    }

    public void setActiveUser(Usuario activeUser) {
        ActiveUser = activeUser;
    }
}
