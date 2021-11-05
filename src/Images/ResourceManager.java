package Images;


public final class ResourceManager {

	private static ResourceProvider provider = null;
	
	
	
	public static ResourceProvider getProvider(){
		
		if(provider == null) {
			provider = new ResourceProviderAmongUs();
		} 
		
		return provider;
		
	}
	
	public static ResourceProvider getProvider(int index){
		
		if(provider == null) {
			
			ResourceProvider[] providerList = new ResourceProvider[1];
			providerList[0] = new ResourceProviderAmongUs();
			
			if(index < providerList.length && index >= 0) { 
				provider = providerList[index];
			} else {
				provider = providerList[0];
			}
		} 
		
		return provider;
	}
	
}
