//
// Pacote ao qual a classe pertence
//
package database.model;

//
// Importa as bibliotecas Java
//

/**
 * 
 * @author Rodrigo F. Santana
 * @version $Revision: 0.0 $
 * 
 *          ======================================================================
 *          Arquivo : $RCSfile: MasterModel.java,v $ Projeto : MasterSys Cria��o
 *          : 21/02/2011 Descri��o : Database Model.
 *          ======================================================================
 * 
 */

public interface MasterModel {
	//
	// Retorna uma linha contendo os valores retornados para pesquisa
	//
    Object[] getSearchLine();
}
