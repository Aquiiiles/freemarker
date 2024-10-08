import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerExample {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration(new Version("2.3.31"));
        cfg.setClassForTemplateLoading(FreeMarkerExample.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("carros.ftl");

        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("Audi", 52642));
        carros.add(new Carro("Volvo", 29000));
        carros.add(new Carro("Skoda", 9000));

        Map<String, Object> data = new HashMap<>();
        data.put("carros", carros);

        StringWriter out = new StringWriter();
        template.process(data, out);
        System.out.println(out.getBuffer().toString());
    }
}

class Carro {
    private String nome;
    private int preco;

    public Carro(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }
}
