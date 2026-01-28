package controllers;

import entities.Compromisso;
import entities.Paticipante;
import enums.OpcaoMenu;
import enums.Prioridade;
import interfaces.CompromissoRepository;
import repositories.CompromissoRepositoryTxtImpl;
import repositories.CompromissoRepositoryXmlImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class CompromissoController {

    private CompromissoRepository repository;

    private Compromisso compromisso;

    public void gerarCompromisso() {

        try {

            this.compromisso = new Compromisso(
                    UUID.randomUUID(),
                    "Workshop: APIs REST com Spring Boot",
                    LocalDate.of(2026, 2, 10),
                    LocalTime.of(19, 0),
                    Prioridade.ALTA
            );

            String[] nomesJava = {
                    "Alice Silva", "Bruno Souza", "Carla Oliveira", "Daniel Santos", "Eduarda Lima",
                    "Fernando Costa", "Gabriela Rocha", "Henrique Melo", "Isabela Pires", "João Victor"
            };

            for (String nome : nomesJava) {
                this.compromisso.adicionarPaticipante(new Paticipante(UUID.randomUUID(),nome));
            }

            var opcaoInformada = Integer.parseInt(JOptionPane
                    .showInputDialog("Para qual formato deseja exportar o compromisso?\n1 - XML\n2 - TXT"));

            OpcaoMenu.getOpcao(opcaoInformada).executar(this);

            JOptionPane.showMessageDialog(null,
                    "Compromisso exportado com sucesso!", null,JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), null,JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exportarParaXml() throws Exception {
        this.repository = new CompromissoRepositoryXmlImpl();
        this.repository.exportar(this.compromisso);
    }

    public void exportarParaTxt() throws Exception {
        this.repository = new CompromissoRepositoryTxtImpl();
        this.repository.exportar(this.compromisso);
    }
}
