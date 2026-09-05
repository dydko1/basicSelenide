package com.dydko.pages.components;

import com.codeborne.selenide.SelenideElement;

public class TextBoxFormComponent extends BaseComponent {

    public TextBoxFormComponent(SelenideElement root) {
        super(root);
    }

    public TextBoxFormComponent setName(String name) {
        root.$("#userName")
                .setValue(name);
        return this;
    }

    public TextBoxFormComponent setEmail(String email) {
        root.$("#userEmail")
                .setValue(email);
        return this;
    }

    public TextBoxFormComponent setCurrentAddress(String address) {
        root.$("#currentAddress")
                .setValue(address);
        return this;
    }

    public TextBoxFormComponent setPermanentAddress(String address) {
        root.$("#permanentAddress")
                .setValue(address);
        return this;
    }

    public void submit() {
        root.$("#submit")
                .scrollTo()
                .click();
    }
}