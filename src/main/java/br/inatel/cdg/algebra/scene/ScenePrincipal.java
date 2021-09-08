package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalcCoefAngular, btnCalcCoefLinear; //Button representa botoes
    private Label labelTeste1, labelTeste2, labelTeste3, labelTeste4; //Label representam rótulos
    private TextField textField1, textField2, textField3, textField4, textField5, textField6; //TextField Representam áreas de texto
    private Double pontoP1X, pontoP1Y, pontoP2X, pontoP2Y, resultAngular, resultLinear;

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelTeste1 = new Label("Ponto P1.X "); //rótulos
        textField1 = new TextField(); //área de texto onde vc digitara alguma coisa
        labelTeste2 = new Label("Ponto P1.Y ");
        textField2 = new TextField();
        labelTeste3 = new Label("Ponto P2.X "); //rótulos
        textField3 = new TextField(); //área de texto onde vc digitara alguma coisa
        labelTeste4 = new Label("Ponto P2.Y ");
        textField4 = new TextField();

        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal1 = new HBox(labelTeste1, textField1, labelTeste2, textField2); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal2 = new HBox(labelTeste3, textField3, labelTeste4, textField4);

        //Agora vamos criar a area que mostrará o que foi digitado
        textField5 = new TextField();
        textField5.setEditable(false);//vamos deixar false para apenas mostrar texto
        textField5.setText("Coef Angular: ");
        textField6 = new TextField();
        textField6.setEditable(false);//vamos deixar false para apenas mostrar texto
        textField6.setText("Coef Linear: ");

        HBox grupoHorizontal3 = new HBox(textField5, textField6);

        //Criamos o botão
        btnCalcCoefAngular = new Button("Calcular Coeficiente Angular");
        btnCalcCoefLinear = new Button("Calcular Coeficiente Linear");

        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefAngular.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            pontoP1X = Double.parseDouble(textField1.getText());
            pontoP1Y = Double.parseDouble(textField2.getText());
            pontoP2X = Double.parseDouble(textField3.getText());
            pontoP2Y = Double.parseDouble(textField4.getText());
            resultAngular = (pontoP2Y-pontoP1Y)/(pontoP2X-pontoP1X);

            textField5.setText(String.valueOf(resultAngular));//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });
        btnCalcCoefLinear.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            resultLinear = pontoP1Y-(resultAngular*pontoP1X);

            textField6.setText(String.valueOf(resultLinear));//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });

        HBox grupoHorizontal4 = new HBox(btnCalcCoefAngular, btnCalcCoefLinear);

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(grupoHorizontal1, grupoHorizontal2, grupoHorizontal3, grupoHorizontal4);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

}
