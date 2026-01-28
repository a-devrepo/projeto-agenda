package enums;

import controllers.CompromissoController;

public enum OpcaoMenu {

    XML(1){
        @Override
        public void executar(CompromissoController controller) throws Exception {
         controller.exportarParaXml();
        }
    }, TXT(2){
        @Override
        public void executar(CompromissoController controller) throws Exception {
            controller.exportarParaTxt();
        }
    };

    private int codigo;

    OpcaoMenu(Integer codigo){
        this.codigo = codigo;
    }

    public abstract void executar(CompromissoController controller) throws Exception;

    public static OpcaoMenu getOpcao(Integer codigo){
        for(OpcaoMenu opcao : OpcaoMenu.values()){
            if(opcao.codigo == codigo){
                return opcao;
            }
        }
        throw new IllegalArgumentException("Opção inválida!");
    }
}