package ogr.user12043.kanban12043.model;

import ogr.user12043.kanban12043.utils.DisplayField;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

/**
 * Created by user12043 on 06.07.2018 - 11:18
 * Part of project: kanban12043
 */
@Entity(name = "TASK_VIEW")
public class TaskView {
    @Id
    @SequenceGenerator(name = "seq_task_view", allocationSize = 1)
    @GeneratedValue(generator = "seq_task_view", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    @DisplayField(key = "entity.common.name")
    private String name;

    @Column(name = "FOREGROUND_COLOR")
    @DisplayField(key = "entity.common.foregroundColor")
    private Color foregroundColor;

    @Column(name = "BACKGROUND_COLOR")
    @DisplayField(key = "entity.common.backgroundColor")
    private Color backgroundColor;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderColumn(name = "id")
    private List<KanbanColumn> kanbanColumns;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderColumn(name = "id")
    private List<Topic> topics;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @OrderColumn(name = "id")
    private List<Tag> tags;

    @Column(name = "STATUSES_CODE")
    private Integer statusesCode;

    @Column(name = "ORDINAL")
    private Integer ordinal; // Change sort property "ordinal" on KanbanColumnSettings.refreshTable when change this property's name

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public List<KanbanColumn> getKanbanColumns() {
        return kanbanColumns;
    }

    public void setKanbanColumns(List<KanbanColumn> kanbanColumns) {
        this.kanbanColumns = kanbanColumns;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getStatusesCode() {
        return statusesCode;
    }

    public void setStatusesCode(Integer statusesCode) {
        this.statusesCode = statusesCode;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer order) {
        this.ordinal = order;
    }
}
