package Images;

import java.util.LinkedList;


/**
 * Class ResourceManager.
 * 
 * Defines the applicable operations of a ResourceManager.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public final class ResourceManager {

	private static ResourceProvider provider = null;
	
	/**
	 * Returns the ResourceProvider.
	 * @return Resource provider.
	 */
	public static ResourceProvider getProvider(){
		
		if( provider == null ) {
			provider = new ResourceProviderAmongUs();
		} 
		
		return provider;
		
	}
	
	
	/**
	 * Returns the ResourceProvider based on the provided index.
	 * @return Resource provider.
	 */
	public static ResourceProvider getProvider(int index){
		
		if(provider == null) {
			
			LinkedList<ResourceProvider> providerList = new LinkedList<ResourceProvider>();
			providerList.add(new ResourceProviderAmongUs());
			
			if(index < providerList.size() && index >= 0) { 
				provider = providerList.get(index);
			} else {
				provider = providerList.get(0);
			}
		} 
		
		return provider;
	}
	
}
