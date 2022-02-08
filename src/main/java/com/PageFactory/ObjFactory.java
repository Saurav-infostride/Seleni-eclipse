package com.PageFactory;

import OrangeHrm.Pages.LoginPage;

public class ObjFactory {
    private LoginPage obj;

    public LoginPage getLogin() {
        if (obj == null) {
            obj = new LoginPage();
        }
        return obj;
    }
}
