package com.kii.cloud.resource.storage;

import java.io.IOException;
import java.util.Map;

import com.kii.cloud.KiiRestException;
import com.kii.cloud.resource.KiiRestRequest;
import com.kii.cloud.resource.KiiRestSubResource;
import com.kii.cloud.resource.KiiRestRequest.Method;
import com.squareup.okhttp.Response;

/**
 * Represents the group member resource like following URI:
 * <ul>
 * <li>https://hostname/api/apps/{APP_ID}/groups/{GROUP_ID}/members/{USER_ID}
 * </ul>
 */
public class KiiGroupMemberResource extends KiiRestSubResource {
	
	private final String userID;
	
	public KiiGroupMemberResource(KiiGroupMembersResource parent, String userID) {
		super(parent);
		this.userID = userID;
	}
	@Override
	public String getPath() {
		return "/" + this.userID;
	}
	/**
	 * @throws KiiRestException
	 * @see http://documentation.kii.com/en/guides/rest/managing-groups/adding-group-members/
	 */
	public void add() throws KiiRestException {
		Map<String, String> headers = this.newAuthorizedHeaders();
		KiiRestRequest request = new KiiRestRequest(getUrl(), Method.PUT, headers);
		try {
			Response response = this.execute(request);
			this.parseResponse(request, response);
		} catch (IOException e) {
			throw new KiiRestException(request.getCurl(), e);
		}
	}
	/**
	 * @throws KiiRestException
	 * @see http://documentation.kii.com/en/guides/rest/managing-groups/adding-group-members/
	 */
	public void remove() throws KiiRestException {
		Map<String, String> headers = this.newAuthorizedHeaders();
		KiiRestRequest request = new KiiRestRequest(getUrl(), Method.DELETE, headers);
		try {
			Response response = this.execute(request);
			this.parseResponse(request, response);
		} catch (IOException e) {
			throw new KiiRestException(request.getCurl(), e);
		}
	}
}
