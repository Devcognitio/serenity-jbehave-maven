package com.devcognitio.todo.definitions;

import com.devcognitio.todo.model.FiltroEstado;
import com.devcognitio.todo.steps.UnUsuario;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GuardarArticuloDefinitions {
    @Steps
    UnUsuario jane;

    @Given("necesito $necesidad")
    public void hacerAlgo(String necesidad) throws Throwable {
        jane.abrirAplicacionTodo();
    }

    @When("agrego el articulo \"$articulo\"")
    @Alias("tengo agregado el articulo \"$articulo\"")
    public void agregarElemento(String articulo) throws Throwable {
        jane.agregarElemento(articulo);
    }

    @Then("el articulo \"$articulo\", debe ser agregado a mi lista de TODO")
    public void articuloAgregadoATodo(String articulo) throws Throwable {
        jane.debeVerElElemento(articulo);
    }

    @Then("\"$action\" should appear in the \"$status\" items")
    @Alias("\"$action\" should be recorded in the \"$status\" items")
    public void action_should_appear_the_items_of_status(String action, String status) throws Throwable {
        jane.filtrarPorEstado(FiltroEstado.valueOf(status));
        jane.debeVerElElemento(action);
    }
}