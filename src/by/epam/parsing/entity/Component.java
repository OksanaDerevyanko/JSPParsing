package by.epam.parsing.entity;

import java.util.List;

public interface Component {

	boolean addTag(Component tag);

	boolean removeTag(Component tag);

	boolean addTags(List<Component> tags);
	
	String getTagName();

	List<Component> getChilds();
}
