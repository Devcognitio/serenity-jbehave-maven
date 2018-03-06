package com.devcognitio.todo.pages;

import com.devcognitio.todo.model.Estado;
import com.devcognitio.todo.model.FiltroEstado;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://todomvc.com/examples/angularjs/#/")
public class TodoPage extends PageObject {

    public static final String FILA_ELEMENTO = "//div[@class='view' and contains(.,'%s')]";
    public static final String FILA_ELEMENTO_LABEL = "//label[contains(.,'%s')]";
    public static final String COMPLETO_TICKBOX = ".//input[@ng-model='todo.completed']";

    public void agrearElemento(String nombreElemento) {
        $("#new-todo").type(nombreElemento)
                .then().sendKeys(Keys.ENTER);
    }

    public List<String> getElementos() {
        return findAll(".view").stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public void filtrarPorEstado(FiltroEstado estado) {
        findBy("#filters")
                .then().findBy(flitroPorEstadoContiene(estado))
                .then().click();
    }

    private String flitroPorEstadoContiene(FiltroEstado estado) {
        return String.format(".//a[.='%s']", estado.name());
    }

    public void marcarCompleto(String nombreElemento) {
        getFilaElemento(nombreElemento).findBy(COMPLETO_TICKBOX).click();
    }

    private WebElementFacade getFilaElemento(String elemento) {
        return $(String.format(FILA_ELEMENTO, elemento));
    }

    private WebElementFacade getNombreFilaElemento(String elemento) {
        return $(String.format(FILA_ELEMENTO_LABEL, elemento));
    }

    public Estado getEstadoElemento(String elemento) {
        WebElementFacade actionRow = getFilaElemento(elemento);
        return estaCompleto(actionRow) ? Estado.Completed : Estado.Active;
    }

    private boolean estaCompleto(WebElementFacade filaElemento) {
        return filaElemento.find(By.tagName("label")).getCssValue("text-decoration").equals("line-through");
    }

    public void actualizarElemento(String elementoActual, String nuevoElemento) {
        evaluateJavascript("arguments[0].click()", getNombreFilaElemento(elementoActual));
        getNombreFilaElemento(elementoActual).type(nuevoElemento);
        getNombreFilaElemento(elementoActual).sendKeys(Keys.RETURN);
    }

    public void limpiarElementosCompletos() {
        $("#clear-completed").click();
    }
}
