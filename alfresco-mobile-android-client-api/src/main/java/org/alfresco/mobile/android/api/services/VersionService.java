/*******************************************************************************
 * Copyright (C) 2005-2012 Alfresco Software Limited.
 * 
 * This file is part of the Alfresco Mobile SDK.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 ******************************************************************************/
package org.alfresco.mobile.android.api.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.alfresco.mobile.android.api.constants.ContentModel;
import org.alfresco.mobile.android.api.model.ContentFile;
import org.alfresco.mobile.android.api.model.Document;
import org.alfresco.mobile.android.api.model.ListingContext;
import org.alfresco.mobile.android.api.model.PagingResult;

/**
 * The Versioning service manages versions of individual document.
 * 
 * @author Jean Marie Pascal
 */
public interface VersionService extends Service
{

    /**
     * Allowable sorting property : Name of the document or folder.
     */
    String SORT_PROPERTY_NAME = ContentModel.PROP_NAME;

    /**
     * Allowable sorting property : Title of the document or folder.
     */
    String SORT_PROPERTY_TITLE = ContentModel.PROP_TITLE;

    /**
     * Allowable sorting property : Description
     */
    String SORT_PROPERTY_DESCRIPTION = ContentModel.PROP_DESCRIPTION;

    /**
     * Allowable sorting property : Creation Date
     */
    String SORT_PROPERTY_CREATED_AT = ContentModel.PROP_CREATED;

    /**
     * Allowable sorting property : Modification Date
     */
    String SORT_PROPERTY_MODIFIED_AT = ContentModel.PROP_MODIFIED;

    /**
     * Get the latest version of a document.
     * 
     * @param document
     * @return
     */
    Document getLatestVersion(Document document);

    /**
     * Get the version history that relates to the referenced document.
     * 
     * @param document : document object in version control.
     * @return Returns a list of documents representing the version history for
     *         the given document.
     */
    List<Document> getVersions(Document document);

    /**
     * Get the version history that relates to the referenced document.
     * 
     * @param document : document object in version control.
     * @param listingContext : defines the behaviour of paging results
     *            {@link org.alfresco.mobile.android.api.model.ListingContext
     *            ListingContext}
     * @return Returns a paged list of documents representing the version
     *         history for the given document.
     */
    PagingResult<Document> getVersions(Document document, ListingContext listingContext);

    /**
     * Checks out the document, if successful the private working copy is
     * returned.
     * 
     * @param document
     * @since 1.4
     * @return
     */
    Document checkout(Document document);

    /**
     * Cancels the check out of the document.
     * 
     * @param document
     * @since 1.4
     */
    void cancelCheckout(Document document);

    /**
     * Checks in the private working copy document, if successful the new
     * version of the document is returned.
     * 
     * @param document
     * @param majorVersion
     * @param file
     * @param properties
     * @param comment
     * @since 1.4
     * @return
     */
    Document checkin(Document document, boolean majorVersion, ContentFile file, Map<String, Serializable> properties,
            String comment);

    /**
     * Returns a list of documents the authenticated user has checked out.
     * 
     * @since 1.4
     * @return
     */
    List<Document> getCheckedOutDocuments();

    /**
     * Returns a paged list of documents the authenticated user has checked out.
     * 
     * @param listingContext
     * @since 1.4
     * @return
     */
    PagingResult<Document> getCheckedOutDocuments(ListingContext listingContext);

}
