const button = document.getElementById("adicionar")
const modal = document.querySelector("dialog");
const buttonClose = document.getElementById("fechar");
const buttonSubmit = document.getElementById("submit")

button.onclick = function(){
  modal.showModal();
}

buttonClose.onclick = function(){
  modal.close();
}

buttonSubmit.onclick = function(){
  window.alert("Cadastrado com sucesso.");
}


document.querySelectorAll(".user-detail").forEach(button => {
        button.addEventListener("click", function() {
            const productId = this.getAttribute("data-id");

            fetch(`/products/${productId}`)
                .then(response => response.json())
                .then(product => {
                    // Carregar a página editProduct.html
                    fetch('/editProduct.html')
                        .then(response => response.text())
                        .then(html => {
                            // Inserir o HTML carregado no modal
                            document.getElementById('modalContent').innerHTML = html;

                            // Preencher os campos do formulário com os dados do produto
                            document.getElementById("productId").value = product.id;
                            document.getElementById("nome").value = product.nome;
                            document.getElementById("descricao").value = product.descricao;
                            document.getElementById("preco").value = product.preco;
                            document.getElementById("SKU").value = product.SKU;
                            document.getElementById("fabricacao").value = product.fabricacao;

                            // Abrir o modal
                            document.getElementById('editModal').style.display = 'block';
                        });
                })
                .catch(error => {
                    console.error("Erro ao carregar os dados do produto:", error);
                });
        });
    });
});

