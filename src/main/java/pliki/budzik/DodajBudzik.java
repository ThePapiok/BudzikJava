package pliki.budzik;

import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class DodajBudzik {
    private Stage stage;
    private Scene scene;
    private ListaBudzikow listaBudzikow;
    @FXML
    private TextField nazwa;
    @FXML
    private TextField godzina;
    @FXML
    private TextField minuta;
    @FXML
    private ToggleButton powTak;
    @FXML
    private ToggleButton powNie;
    @FXML
    private CheckBox pon;
    @FXML
    private CheckBox wt;
    @FXML
    private CheckBox sr;
    @FXML
    private CheckBox czw;
    @FXML
    private CheckBox pt;
    @FXML
    private CheckBox sob;
    @FXML
    private CheckBox nd;
    @FXML
    private Slider poziomGlos;
    @FXML
    private Label blad;



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setListaBudzikow(ListaBudzikow listaBudzikow)
    {
        this.listaBudzikow=listaBudzikow;
    }

    public void anuluj() {
        stage.setScene(scene);
    }

    public void resetScene() {
        nazwa.setText("");
        poziomGlos.setValue(100);
        blad.setText("");
        powNie.setSelected(true);
        pon.setSelected(false);
        wt.setSelected(false);
        sr.setSelected(false);
        czw.setSelected(false);
        pt.setSelected(false);
        sob.setSelected(false);
        nd.setSelected(false);
        LocalDateTime localDateTime=LocalDateTime.now();
        String godzinaString=String.valueOf(localDateTime.getHour());
        if(godzinaString.length()==1)
        {
            godzinaString="0"+godzinaString;
        }
        String minutaString=String.valueOf(localDateTime.getMinute());
        if(minutaString.length()==1)
        {
            minutaString="0"+minutaString;
        }
        godzina.setText(godzinaString);
        minuta.setText(minutaString);
        int dzien=localDateTime.getDayOfWeek().getValue();
        switch (dzien) {
            case 1:
                pon.setSelected(true);
                break;
            case 2:
                wt.setSelected(true);
                break;
            case 3:
                sr.setSelected(true);
                break;
            case 4:
                czw.setSelected(true);
                break;
            case 5:
                pt.setSelected(true);
                break;
            case 6:
                sob.setSelected(true);
                break;
            case 7:
                nd.setSelected(true);
                break;
        }

    }

    public void zapisz() {
        if(nazwa.getLength()>0&&nazwa.getLength()<=20)
        {
            int ilosc=0;
            String dni="";
            if(pon.isSelected())
            {
                ilosc++;
                dni="pon";
            }
            if(wt.isSelected())
            {
                ilosc++;
                if(ilosc==1)
                {
                    dni="wt";
                }
                else
                {
                    dni+=",wt";
                }
            }
            if(sr.isSelected())
            {
                ilosc++;
                if(ilosc==1)
                {
                    dni="sr";
                }
                else
                {
                    dni+=",sr";
                }
            }
            if(czw.isSelected())
            {
                ilosc++;
                if(ilosc==1)
                {
                    dni="czw";
                }
                else
                {
                    dni+=",czw";
                }
            }
            if(pt.isSelected())
            {
                ilosc++;
                if(ilosc==1)
                {
                    dni="pt";
                }
                else
                {
                    dni+=",pt";
                }
            }
            if(sob.isSelected())
            {
                ilosc++;
                if(ilosc==1)
                {
                    dni="sob";
                }
                else
                {
                    dni+=",sob";
                }
            }
            if(nd.isSelected())
            {
                ilosc++;
                if(ilosc==1)
                {
                    dni="nd";
                }
                else
                {
                    dni+=",nd";
                }
            }
            if(ilosc>0)
            {
                String powtarzanie;
                if(powTak.isSelected())
                {
                    powtarzanie="Tak";
                }
                else {
                    powtarzanie = "Nie";
                }
                int glosnosc= (int) poziomGlos.getValue();
                String budzik="nazwa: "+nazwa.getText()+" dni: "+dni+" godzina: "+godzina.getText()+":"+minuta.getText()+" powtarzanie: "+powtarzanie+" glosnosc: "+glosnosc+"%";
                listaBudzikow.addToList(budzik);
                stage.setScene(scene);
            }
            else
            {
                blad.setText("Musisz wybrac conajmniej jeden dzien.");
            }

        }
        else
        {
            blad.setText("Dlugosc nazwy Alarmu musi miec od 1 do 20 znakow.");
        }
    }

    public void zwiekszGodzine(){
        int godzinaInt= Integer.parseInt(godzina.getText());
        godzinaInt++;
        if(godzinaInt==24)
        {
            godzinaInt=0;
        }
        String godzinaString=String.valueOf(godzinaInt);
        if(godzinaString.length()==1)
        {
            godzinaString="0"+godzinaString;
        }
        godzina.setText(godzinaString);
    }
    public void zmniejszGodzine(){
        int godzinaInt= Integer.parseInt(godzina.getText());
        godzinaInt--;
        if(godzinaInt==-1)
        {
            godzinaInt=23;
        }
        String godzinaString=String.valueOf(godzinaInt);
        if(godzinaString.length()==1)
        {
            godzinaString="0"+godzinaString;
        }
        godzina.setText(godzinaString);

    }
    public void zwiekszMinute(){
        int minutaInt= Integer.parseInt(minuta.getText());
        minutaInt++;
        if(minutaInt==60)
        {
            minutaInt=0;
        }
        String minutaString=String.valueOf(minutaInt);
        if(minutaString.length()==1)
        {
            minutaString="0"+minutaString;
        }
        minuta.setText(minutaString);

    }
    public void zmniejszMinute()
    {
        int minutaInt= Integer.parseInt(minuta.getText());
        minutaInt--;
        if(minutaInt==-1)
        {
            minutaInt=59;
        }
        String minutaString=String.valueOf(minutaInt);
        if(minutaString.length()==1)
        {
            minutaString="0"+minutaString;
        }
        minuta.setText(minutaString);
    }
    public void all()
    {
        pon.setSelected(true);
        wt.setSelected(true);
        sr.setSelected(true);
        czw.setSelected(true);
        pt.setSelected(true);
        sob.setSelected(true);
        nd.setSelected(true);
    }
}