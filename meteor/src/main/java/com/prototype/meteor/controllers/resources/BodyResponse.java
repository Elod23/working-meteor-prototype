package com.prototype.meteor.controllers.resources;

public class BodyResponse {

    private boolean success;
    private Error error;
    private Object data;
	private Object data2;

	private BodyResponse(boolean success, Error error, Object data, Object data2) {
        this.success = success;
        this.error = error;
        this.data = data;
		this.data2 = data2;
    }

	public Object getData2() {
		return data2;
	}

    public boolean isSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public Object getData() {
        return data;
    }

    public static class Builder {
        private boolean success;
        private Error error;
        private Object data;
		private Object data2;

        public Builder withSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public Builder withError(Error error) {
            this.error = error;
            return this;
        }

        public Builder withData(Object data) {
            this.data = data;
            return this;
        }

		public Builder withData2(Object data2) {
			this.data2 = data2;
			return this;
		}

        public BodyResponse build() {
			return new BodyResponse(this.success, this.error, this.data, this.data2);
        }

    }
}

