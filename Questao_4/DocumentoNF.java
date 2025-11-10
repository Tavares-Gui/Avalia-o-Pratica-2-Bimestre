package Questao_4;

import java.util.HashMap;
import java.util.Map;

public class DocumentoNF {
    private String xml;
    private String numero;
    private String chave;
    private Map<String, Object> atributos = new HashMap<>();

    public DocumentoNF(String xml, String numero, String chave) {
        this.xml = xml;
        this.numero = numero;
        this.chave = chave;
    }

    public String getXml() { return xml; }
    public String getNumero() { return numero; }
    public String getChave() { return chave; }

    public void setAtributo(String chave, Object valor) { atributos.put(chave, valor); }
    public Object getAtributo(String chave) { return atributos.get(chave); }

    @Override
    public String toString() {
        return "DocumentoFiscal{numero='" + numero + "', chave='" + chave + "', atributos=" + atributos + "}";
    }
}
