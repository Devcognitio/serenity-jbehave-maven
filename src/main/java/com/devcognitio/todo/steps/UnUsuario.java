package com.devcognitio.todo.steps;

import com.devcognitio.todo.model.FiltroEstado;
import com.devcognitio.todo.pages.TodoPage;
import net.thucydides.core.annotations.Step;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class UnUsuario {


    @Step
    public void abrirAplicacionTodo() {
        todoPage.open();
    }

    TodoPage todoPage;

    @Step
    public void agregarElemento(String nombreElemento) {
        todoPage.agrearElemento(nombreElemento);
    }

    @Step
    public void agregarElementos(String... nombreElemento) {
        newArrayList(nombreElemento).forEach(
                action -> agregarElemento(action)
        );
    }

    @Step
    public void debeVerElElemento(String nombreElemento) {
        assertThat(todoPage.getElementos()).contains(nombreElemento);
    }

    @Step
    public void debeVerLosElementos(String... nombreElemento) {
        assertThat(todoPage.getElementos()).containsExactly(nombreElemento);
    }

    @Step
    public void filtrarPorEstado(FiltroEstado estado) {
        todoPage.filtrarPorEstado(estado);
    }

}