/**
 * 
 */
package Contract;

import Model.Niveau;

/**
 * fonction servant à la mise à jour des éléments du niveau
 * 
 */
public interface Refresh {

	public void refresh(Niveau N);

	public void refreshAnim();

	public boolean stayInUpTable();
}
