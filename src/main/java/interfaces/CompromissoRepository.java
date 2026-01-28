package interfaces;

import entities.Compromisso;

public interface CompromissoRepository {
    void exportar(Compromisso compromisso) throws Exception;
}