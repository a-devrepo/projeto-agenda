package repositories;

import entities.Compromisso;
import interfaces.CompromissoRepository;

import java.io.PrintWriter;

public class CompromissoRepositoryTxtImpl implements CompromissoRepository {

    @Override
    public void exportar(Compromisso compromisso) throws Exception {

        try {
            var printWriter = new PrintWriter("/tmp/compromisso_" + compromisso.getId() + ".txt");

            printWriter.println("Titulo: " + compromisso.getTitulo() + System.lineSeparator());
            printWriter.println("Data: " + compromisso.getData() + System.lineSeparator());
            printWriter.println("Hora: " + compromisso.getHora() + System.lineSeparator());
            printWriter.println("Prioridade: " + compromisso.getPrioridade() + System.lineSeparator());
            printWriter.println("Paticipantes: " + System.lineSeparator());

            for (var participante : compromisso.getPaticipantes()) {
                printWriter.println("\tId: " + participante.getId() + " Nome: " +
                        participante.getNome() + System.lineSeparator());
            }

            printWriter.close();
        } catch (Exception e) {
            throw new Exception("Erro ao exportar compromisso para .txt: ", e);
        }
    }
}
