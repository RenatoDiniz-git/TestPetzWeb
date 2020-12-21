package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;


public class PetzTest {
    @Test
    public void testPetz(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Renato JR.LAPTOP-RTMETIU3\\IdeaProjects\\TestePetz\\drivers\\chromedriver.exe");
        WebDriver Navegador = new ChromeDriver();
        Navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Abrindo o site pelo navegador
         Navegador.get("http://www.petz.com.br");

        //1-Consulte por "Ração"
         Navegador.findElement(By.className("inputPesquisa")).sendKeys("Ração");
         Navegador.findElement(By.className("button-search")).click();

         //Screenshot - item 1
         Screenshot.tirar(Navegador, "C:\\Users\\...\\reportes_teste\\Petz" + Generator.dataHoraParaArquivo() + "Retorno Lista.png" );

        //2-Selecione o terceiro produto da lista retornada.
         WebElement name = Navegador.findElement(By.className("nome_produto"));
         String titulo = name.getText();

         //Screenshot - item 2
         Screenshot.tirar(Navegador, "C:\\Users\\Renato JR.LAPTOP-RTMETIU3\\reportes_teste\\Petz" + Generator.dataHoraParaArquivo() + "Produto.png" );

        //3-Valide o nome do produto, fornecedor, preço normal e preço para assinante
        //Assert.assertEquals();

        //Screenshot - item 3


        //4-Insira o produto no carrinho de compras
         Navegador.findElement(By.id("adicionarAoCarrinho")).click();

         //Screenshot - item 4
         Screenshot.tirar(Navegador, "C:\\Users\\Renato JR.LAPTOP-RTMETIU3\\reportes_teste\\Petz" + Generator.dataHoraParaArquivo() + "Adicionar Produto.png" );


        //5-Valide se os dados do item 3 continuam idênticos
         WebElement preço = Navegador.findElement(By.className("preco"));
         String valor = preço.getText();
         assertEquals("R$ 232,69", valor);

         WebElement NomeProd = Navegador.findElement(By.className("resumo"));
         String nome = NomeProd.getText();
         assertEquals("Ração Royal Canin Maxi - Cães Adultos - 15kg - 15kg", nome);

         //Screenshot - item 5
         Screenshot.tirar(Navegador, "C:\\Users\\Renato JR.LAPTOP-RTMETIU3\\reportes_teste\\Petz" + Generator.dataHoraParaArquivo() + " Checando Produtos.png" );

         Assert.assertEquals(1,  1);

        //Fechar Navegador
         Navegador.quit();
    }
}
