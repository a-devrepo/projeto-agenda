package repositories;

import entities.Compromisso;
import interfaces.CompromissoRepository;

import java.io.PrintWriter;

public class CompromissoRepositoryXmlImpl implements CompromissoRepository {

    @Override
    public void exportar(Compromisso compromisso) throws Exception {

        try {

            var printWriter = new PrintWriter("/tmp/compromisso_" + compromisso.getId() + ".xml");

            printWriter.println("<?xml version='1.0' encoding='UTF-8'?>");
            printWriter.println("<compromisso>");
            printWriter.println("\t<id>" + compromisso.getId() + "</id>");
            printWriter.println("\t<titulo>" + compromisso.getTitulo() + "</titulo>");
            printWriter.println("\t<data>" + compromisso.getData() + "</data>");
            printWriter.println("\t<hora>" + compromisso.getHora() + "</hora>");
            printWriter.println("\t<prioridade>" + compromisso.getPrioridade() + "</prioridade>");
            printWriter.println("\t<paticipantes>");

            for (var paticipante : compromisso.getPaticipantes()) {
                printWriter.println("\t\t<paticipante>");
                printWriter.println("\t\t\t<id>" + paticipante.getId() + "</id>");
                printWriter.println("\t\t\t<nome>" + paticipante.getNome() + "</nome>");
                printWriter.println("\t\t</paticipante>");
            }

            printWriter.println("\t</paticipantes>");
            printWriter.println("</compromisso>");
            printWriter.close();
        } catch (Exception e) {
            throw new Exception("Erro ao exportar compromisso para .xml: ", e);
        }
    }
}

