package Utils;

import java.util.Map;
import java.util.Properties;
import com.ibm.fhir.client.FHIRClient;
import com.ibm.fhir.client.FHIRClientFactory;
import com.ibm.fhir.client.FHIRParameters;
import com.ibm.fhir.client.FHIRResponse;
import com.ibm.fhir.model.resource.Bundle;
import com.ibm.fhir.model.resource.Resource;

public class HttpUtils {
	
	private FHIRClient getPropertiesClient() throws Exception {
		Properties clientProperties = new Properties();
        clientProperties.setProperty(FHIRClient.PROPNAME_BASE_URL, System.getenv("FHIR_HTTP_URL"));
        clientProperties.setProperty(FHIRClient.PROPNAME_BASIC_AUTH_ENABLED, "true");
        clientProperties.setProperty(FHIRClient.PROPNAME_CLIENT_USERNAME, System.getenv("FHIR_HTTP_USER_NAME"));
        clientProperties.setProperty(FHIRClient.PROPNAME_CLIENT_PASSWORD, System.getenv("FHIR_HTTP_PASSWORD"));
        clientProperties.setProperty(FHIRClient.PROPNAME_TRUSTSTORE_LOCATION, System.getenv("FHIR_HTTP_TRUSTSTORE_PATH"));
        clientProperties.setProperty(FHIRClient.PROPNAME_TRUSTSTORE_PASSWORD, System.getenv("FHIR_HTTP_TRUSTSTORE_PASSWORD"));
        return FHIRClientFactory.getClient(clientProperties);
	}
	
	public Resource getResourceById(String resourceName, String id) throws Exception {
		if (resourceName == null || resourceName.length() == 0) {
			return null;
		}
		
		FHIRClient client = this.getPropertiesClient();
		FHIRResponse response = client.read(resourceName, id, null);
		return response.getResource(Resource.class);
	}
		
	public Bundle getResourceByParameters(String resourceName, Map<String, String> parameterMap) throws Exception {
		if (resourceName == null || resourceName.length() == 0) {
			return null;
		}
		
		FHIRClient client = this.getPropertiesClient();
		FHIRParameters fhirParameters = null;
		
		if (parameterMap != null) {
			fhirParameters = new FHIRParameters();
			for (String key : parameterMap.keySet()) {
				fhirParameters.queryParam(key, parameterMap.get(key));
			}
		}
		
		FHIRResponse response = client.search(resourceName, fhirParameters, null);
		return response.getResource(Bundle.class);
	}
	
	public FHIRResponse create(Resource resource) throws Exception {
        FHIRClient client = this.getPropertiesClient();
        return client.create(resource);
	}
	
	public FHIRResponse delete(Resource resource, String id) throws Exception {
		if (id == null || id.length() == 0) {
			return null;
		}
		
        FHIRClient client = this.getPropertiesClient();
        return client.delete(resource.getClass().getSimpleName(), id, null);
	}
	
	public FHIRResponse update(Resource resource) throws Exception {
        FHIRClient client = this.getPropertiesClient();
        return client.update(resource, null);
	}
	
	public FHIRResponse validate(Resource resource) throws Exception {
        FHIRClient client = this.getPropertiesClient();
        return client.validate(resource, null);
	}
}
