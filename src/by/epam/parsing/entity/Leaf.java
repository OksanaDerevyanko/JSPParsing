package by.epam.parsing.entity;

import java.util.List;

public class Leaf implements Component {

	private String tagName;
	private String parentName;

	public Leaf(String tagName, String parentName) {
		super();
		this.tagName = tagName;
		this.parentName = parentName;
	}

	public Leaf(String tagName) {
		super();
		this.tagName = tagName;
	}
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String getTagName() {
		return tagName;
	}

	@Override
	public boolean addTag(Component tag) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeTag(Component tag) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addTags(List<Component> tags) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Component> getChilds() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
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
		Leaf other = (Leaf) obj;
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Leaf [tagContent=" + tagName + "]";
	}

}
