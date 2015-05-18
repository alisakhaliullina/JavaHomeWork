package com.example.tests;

public class GroupObject implements Comparable<GroupObject> {
	public String name;
	public String header;
	public String footer;

	public GroupObject(String name, String header, String footer) {
		this.name = name;
		this.header = header;
		this.footer = footer;
	}

	public GroupObject() {
		
	}

	@Override
		public String toString() {
			return "GroupObject [name=" + name + "]";
		}

	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
		return result;
		}

	@Override
		public boolean equals(Object obj) {
				if (this == obj)
			return true;
				if (obj == null)
			return false;
				if (getClass() != obj.getClass())
			return false;
		GroupObject other = (GroupObject) obj;
				if (name == null) {
					if (other.name != null)
				return false;
				} 
				else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
		public int compareTo(GroupObject other) {
			return this.name.toLowerCase().compareTo(other.name.toLowerCase());
		}

		public GroupObject setName(String name) {
				this.name = name;
			return this;
		}
		public GroupObject setHeader(String header) {
				this.header = header;
			return this;
		}
		public GroupObject setFooter(String footer) {
				this.footer = footer;
			return this;
		}
	
}