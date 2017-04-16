package com.braunster.chatsdk.dao;

import java.util.List;

import com.braunster.chatsdk.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import com.braunster.chatsdk.Utils.Debug;
import com.braunster.chatsdk.dao.entities.BMessageEntity;
import com.braunster.chatsdk.dao.entities.Entity;
import com.braunster.chatsdk.network.BFirebaseDefines;
import com.braunster.chatsdk.network.BNetworkManager;
import com.braunster.chatsdk.network.BPath;

import java.util.Calendar;

import de.greenrobot.dao.DaoException;
import timber.log.Timber;
// KEEP INCLUDES END
/**
 * Entity mapped to table BMESSAGE.
 */
public class BMessage extends BMessageEntity  {

    private Long id;
    private String entityID;
    private java.util.Date date;
    private Boolean isRead;
    private String resources;
    private String resourcesPath;
    private String text;
    private String imageDimensions;
    private Integer type;
    private Integer status;
    private Integer delivered;
    private Long Sender;
    private Long threadDaoId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BMessageDao myDao;

    private BUser BUserSender;
    private Long BUserSender__resolvedKey;

    private BThread thread;
    private Long thread__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    public static final String TAG = BMessage.class.getSimpleName();
    public static final boolean DEBUG = Debug.BMessage;
    public String color = null;
    public String fontName = null;
    public String textColor = null;
    public int fontSize = -1;
    // KEEP FIELDS END

    public BMessage() {
    }

    public BMessage(Long id) {
        this.id = id;
    }

    public BMessage(Long id, String entityID, java.util.Date date, Boolean isRead, String resources, String resourcesPath, String text, String imageDimensions, Integer type, Integer status, Integer delivered, Long Sender, Long threadDaoId) {
        this.id = id;
        this.entityID = entityID;
        this.date = date;
        this.isRead = isRead;
        this.resources = resources;
        this.resourcesPath = resourcesPath;
        this.text = text;
        this.imageDimensions = imageDimensions;
        this.type = type;
        this.status = status;
        this.delivered = delivered;
        this.Sender = Sender;
        this.threadDaoId = threadDaoId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBMessageDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String resourcesPath) {
        this.resourcesPath = resourcesPath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageDimensions() {
        return imageDimensions;
    }

    public void setImageDimensions(String imageDimensions) {
        this.imageDimensions = imageDimensions;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    public Long getSender() {
        return Sender;
    }

    public void setSender(Long Sender) {
        this.Sender = Sender;
    }

    public Long getThreadDaoId() {
        return threadDaoId;
    }

    public void setThreadDaoId(Long threadDaoId) {
        this.threadDaoId = threadDaoId;
    }

    /** To-one relationship, resolved on first access. */
    public BUser getBUserSender() {
        Long __key = this.Sender;
        if (BUserSender__resolvedKey == null || !BUserSender__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserDao targetDao = daoSession.getBUserDao();
            BUser BUserSenderNew = targetDao.load(__key);
            synchronized (this) {
                BUserSender = BUserSenderNew;
            	BUserSender__resolvedKey = __key;
            }
        }
        return BUserSender;
    }

    public void setBUserSender(BUser BUserSender) {
        synchronized (this) {
            this.BUserSender = BUserSender;
            Sender = BUserSender == null ? null : BUserSender.getId();
            BUserSender__resolvedKey = Sender;
        }
    }

    /** To-one relationship, resolved on first access. */
    public BThread getThread() {
        Long __key = this.threadDaoId;
        if (thread__resolvedKey == null || !thread__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BThreadDao targetDao = daoSession.getBThreadDao();
            BThread threadNew = targetDao.load(__key);
            synchronized (this) {
                thread = threadNew;
            	thread__resolvedKey = __key;
            }
        }
        return thread;
    }

    public void setThread(BThread thread) {
        synchronized (this) {
            this.thread = thread;
            threadDaoId = thread == null ? null : thread.getId();
            thread__resolvedKey = threadDaoId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public BPath getBPath() {
        if (getThread() == null)
        {
            if (DEBUG) Timber.e("Owner Thread is null");
            return null;
        }
        return getThread().getBPath().addPathComponent(BFirebaseDefines.Path.BMessagesPath, entityID);
    }

    @Override
    public Entity.Type getEntityType() {
        return Entity.Type.bEntityTypeMessages;
    }

    public boolean isSameDayAsMessage(BMessage message){
        // Current time.
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(date);
        // Message time.
        Calendar messageCalendar = Calendar.getInstance();
        messageCalendar.setTime(message.getDate());
        // Compare
        return isSameDay(nowCalendar, messageCalendar);
    }

    private boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null)
            return false;

        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    public boolean isMine(){
        return getBUserSender().equals(BNetworkManager.getCoreInterface().currentUserModel());
    }

    @Override
    public String color() {
        return getBUserSender().getMessageColor();
    }

    public Integer getStatusOrNull(){
        if (status == null)
            status = BMessageEntity.Status.NULL;

        return status;
    }
    
    public int wasDelivered(){
       return delivered == null ?  Delivered.Yes :  delivered;
        
    }

    /** Null safe version of getIsRead*/
    public boolean wasRead(){
        return isRead==null || isRead;
    }

    @Override
    public String toString() {
        return String.format("BMessage, id: %s, type: %s, Sender: %s", id, type, getBUserSender());
    }
    // KEEP METHODS END

}
