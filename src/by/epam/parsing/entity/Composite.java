package by.epam.parsing.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

	private List<Component> childTags = new ArrayList<>();
	private String tagName;
	private String parentName;

	public Composite(String tagName) {
		super();
		this.tagName = tagName;
	}

	public Composite(String tagName, List<Component> childTags) {
		super();
		this.childTags = childTags;
		this.tagName = tagName;
	}

	public Composite(String tagName, String parentName) {
		super();
		this.tagName = tagName;
		this.parentName = parentName;
	}

	public String getParentName() {
		return parentName;
	}

	public String getTagName() {
		return tagName;
	}

	@Override
	public boolean addTag(Component tag) {
		return childTags.add(tag);
	}

	@Override
	public boolean removeTag(Component tag) {
		return childTags.remove(tag);
	}

	public boolean addTags(List<Component> tags) {
		return childTags.addAll(tags);
	}

	@Override
	public List<Component> getChilds() {
		return childTags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((childTags == null) ? 0 : childTags.hashCode());
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
		Composite other = (Composite) obj;
		if (childTags == null) {
			if (other.childTags != null)
				return false;
		} else if (!childTags.equals(other.childTags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Composite [childTags=" + childTags + "]";
	}

}
