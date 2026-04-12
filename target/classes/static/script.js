const url = "http://localhost:2214/LojaGames";

function salvar(){
    const jogo = {
        nome: document.getElementById("nome").value,
        preco: parseFloat(document.getElementById("preco").value),
        categoria: document.getElementById("categoria").value,
        codigoAtivacao: parseInt(document.getElementById("codigoAtivacao").value)
    };

    fetch(url, {
        method: "POST",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(jogo)
    }).then(() => listar());
}

function listar() {
    fetch(url)
        .then(res => res.json())
        .then(dados => {
            const lista = document.getElementById("lista");
            lista.innerHTML = "";

            dados.forEach(jogo => {
                const li = document.createElement("li");
                 li.innerText = `${jogo.nome} - R$ ${jogo.preco} - ${jogo.categoria} - Código: ${jogo.codigoAtivacao}`;
                 lista.appendChild(li);
            });
        });
}
listar();