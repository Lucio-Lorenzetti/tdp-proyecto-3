package Images;

import java.util.LinkedList;

public final class ResourceManager {

	private static ResourceProvider provider = null;
	
	public static ResourceProvider getProvider(){
		
		if( provider == null ) {
			provider = new ResourceProviderAmongUs();
		} 
		
		return provider;
		
	}
	
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
