package com.shulpin.client;

public class BookService_Generated_RestServiceProxy_ implements com.shulpin.client.BookService, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("lib/books");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void addBook(java.lang.String sortedBy, com.shulpin.shared.Book book, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.shulpin.shared.Book>> callback) {
    final java.lang.String final_sortedBy = sortedBy;
    final com.shulpin.shared.Book final_book = book;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/add/"+(sortedBy== null? null : com.google.gwt.http.client.URL.encodePathSegment(sortedBy))+"")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, "application/json");
    __method.json(com.shulpin.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE.encode(book));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.shulpin.shared.Book>>(__method, callback) {
        protected java.util.List<com.shulpin.shared.Book> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.shulpin.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void deleteBook(java.lang.String sortedBy, java.lang.Long id, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.shulpin.shared.Book>> callback) {
    final java.lang.String final_sortedBy = sortedBy;
    final java.lang.Long final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/delete/"+((id != null ? id.toString() : null)== null? null : com.google.gwt.http.client.URL.encodePathSegment((id != null ? id.toString() : null)))+"/"+(sortedBy== null? null : com.google.gwt.http.client.URL.encodePathSegment(sortedBy))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.shulpin.shared.Book>>(__method, callback) {
        protected java.util.List<com.shulpin.shared.Book> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.shulpin.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getAllBooks(java.lang.String sortedBy, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.shulpin.shared.Book>> callback) {
    final java.lang.String final_sortedBy = sortedBy;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(sortedBy== null? null : com.google.gwt.http.client.URL.encodePathSegment(sortedBy))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.shulpin.shared.Book>>(__method, callback) {
        protected java.util.List<com.shulpin.shared.Book> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.shulpin.shared.Book_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
}
