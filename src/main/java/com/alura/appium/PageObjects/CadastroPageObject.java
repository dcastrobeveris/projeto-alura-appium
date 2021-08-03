package com.alura.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject {

    private AppiumDriver driver;
    private MobileElement campoNome;
    private MobileElement campoSenha;
    private MobileElement campoConfirmarSenha;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErro;

    public CadastroPageObject(AppiumDriver driver){
        this.driver = driver;
    }
    public void BuscarElementos(){
        campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        campoConfirmarSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    private void PreencherFormulario(String usuario, String senha, String confirmacao){
        campoNome.setValue(usuario);
        campoSenha.setValue(senha);
        campoConfirmarSenha.setValue(confirmacao);
    }

    public LoginPageObject Cadastrar(String usuario, String senha, String confirmacao) {
        PreencherFormulario(usuario, senha, confirmacao);
        botaoCadastrar.click();
        return new LoginPageObject(driver);
    }

    public String MensagemErro(){
        By erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(erroID));
        mensagemErro = (MobileElement) driver.findElement(erroID);
        return mensagemErro.getText();
    }
}
