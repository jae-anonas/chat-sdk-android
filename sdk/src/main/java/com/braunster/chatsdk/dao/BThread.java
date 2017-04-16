package com.braunster.chatsdk.dao;

import java.util.List;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import com.braunster.chatsdk.Utils.Debug;
import com.braunster.chatsdk.Utils.sorter.MessageSorter;
import com.braunster.chatsdk.dao.core.DaoCore;
import com.braunster.chatsdk.dao.entities.BThreadEntity;
import com.braunster.chatsdk.dao.entities.Entity;
import com.braunster.chatsdk.network.BFirebaseDefines;
import com.braunster.chatsdk.network.BNetworkManager;
import com.braunster.chatsdk.network.BPath;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import timber.log.Timber;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS
// KEEP INCLUDES END
/**
 * Entity mapped to table BTHREAD.
 */
public class BThread extends BThreadEntity  {

    private Long id;
    private String entityID;
    private java.util.Date creationDate;
    private Boolean hasUnreadMessages;
    private Boolean deleted;
    private String name;
    private java.util.Date LastMessageAdded;
    private Integer type;
    private String creatorEntityId;
    private String imageUrl;
    private String rootKey;
    private String apiKey;
    private Long creator_ID;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BThreadDao myDao;

    private BUser creator;
    private Long creator__resolvedKey;

    private List<UserThreadLink> userThreadLinks;
    private List<BMessage> messages;

    // KEEP FIELDS - put your custom fields here
    private static final boolean DEBUG = Debug.BThread;
    // KEEP FIELDS END

    public BThread() {
    }

    public BThread(Long id) {
        this.id = id;
    }

    public BThread(Long id, String entityID, java.util.Date creationDate, Boolean hasUnreadMessages, Boolean deleted, String name, java.util.Date LastMessageAdded, Integer type, String creatorEntityId, String imageUrl, String rootKey, String apiKey, Long creator_ID) {
        this.id = id;
        this.entityID = entityID;
        this.creationDate = creationDate;
        this.hasUnreadMessages = hasUnreadMessages;
        this.deleted = deleted;
        this.name = name;
        this.LastMessageAdded = LastMessageAdded;
        this.type = type;
        this.creatorEntityId = creatorEntityId;
        this.imageUrl = imageUrl;
        this.rootKey = rootKey;
        this.apiKey = apiKey;
        this.creator_ID = creator_ID;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBThreadDao() : null;
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

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getHasUnreadMessages() {
        return hasUnreadMessages;
    }

    public void setHasUnreadMessages(Boolean hasUnreadMessages) {
        this.hasUnreadMessages = hasUnreadMessages;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getLastMessageAdded() {
        return LastMessageAdded;
    }

    public void setLastMessageAdded(java.util.Date LastMessageAdded) {
        this.LastMessageAdded = LastMessageAdded;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreatorEntityId() {
        return creatorEntityId;
    }

    public void setCreatorEntityId(String creatorEntityId) {
        this.creatorEntityId = creatorEntityId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRootKey() {
        return rootKey;
    }

    public void setRootKey(String rootKey) {
        this.rootKey = rootKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Long getCreator_ID() {
        return creator_ID;
    }

    public void setCreator_ID(Long creator_ID) {
        this.creator_ID = creator_ID;
    }

    /** To-one relationship, resolved on first access. */
    public BUser getCreator() {
        Long __key = this.creator_ID;
        if (creator__resolvedKey == null || !creator__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserDao targetDao = daoSession.getBUserDao();
            BUser creatorNew = targetDao.load(__key);
            synchronized (this) {
                creator = creatorNew;
            	creator__resolvedKey = __key;
            }
        }
        return creator;
    }

    public void setCreator(BUser creator) {
        synchronized (this) {
            this.creator = creator;
            creator_ID = creator == null ? null : creator.getId();
            creator__resolvedKey = creator_ID;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<UserThreadLink> getUserThreadLinks() {
        if (userThreadLinks == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserThreadLinkDao targetDao = daoSession.getUserThreadLinkDao();
            List<UserThreadLink> userThreadLinksNew = targetDao._queryBThread_UserThreadLinks(id);
            synchronized (this) {
                if(userThreadLinks == null) {
                    userThreadLinks = userThreadLinksNew;
                }
            }
        }
        return userThreadLinks;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetUserThreadLinks() {
        userThreadLinks = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BMessage> getMessages() {
        if (messages == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BMessageDao targetDao = daoSession.getBMessageDao();
            List<BMessage> messagesNew = targetDao._queryBThread_Messages(id);
            synchronized (this) {
                if(messages == null) {
                    messages = messagesNew;
                }
            }
        }
        return messages;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMessages() {
        messages = null;
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
        return new BPath().addPathComponent(BFirebaseDefines.Path.BThreadPath, getEntityID());}

    @Override
    public Entity.Type getEntityType() {
        return com.braunster.chatsdk.dao.entity_interface.Entity.Type.bEntityTypeThread;
    }

    public void setMessages(List<BMessage> messages) {
        this.messages = messages;
    }

    public List<BUser> getUsers(){
        /* Getting the users list by getUserThreadLink can be out of date so we get the data from the database*/

        List<UserThreadLink> list =  DaoCore.fetchEntitiesWithProperty(UserThreadLink.class, UserThreadLinkDao.Properties.BThreadDaoId, getId());

        if (DEBUG) Timber.d("BThread, getUsers, Amount: %s", (list == null ? "null" : list.size()));

        List<BUser> users  = new ArrayList<BUser>();

        if (list == null) {
            return users;
        }

        for (UserThreadLink data : list)
            if (data.getBUser() != null && !users.contains(data.getBUser()))
                users.add(data.getBUser());

        return users;
    }

    public String threadImageUrl(){
        if (StringUtils.isNotBlank(imageUrl))
            return imageUrl;

        return threadImageUrl(getUsers());
    }

    /** Retrieve the thread usable image url, Only for private threads.
     *  If the thread as two users the other user(not the current) image url will be used.
     *  If thread has more users then we will take 2/3 first users images that we could find, This will be used to make a combine image for the thread. {@link com.braunster.chatsdk.Utils.asynctask.MakeThreadImage MakeThreadImage} */
    public String threadImageUrl(List<BUser> users){
        String url = "";
        String curUserEntity = BNetworkManager.getCoreInterface().currentUserModel().getEntityID();

        if (getTypeSafely() == Type.Private) {
            if (users.size() == 2) {
                if (!users.get(0).getEntityID().equals(curUserEntity))
                    url = users.get(0).getThumbnailPictureURL();
                else if (!users.get(1).getEntityID().equals(curUserEntity))
                    url = users.get(1).getThumbnailPictureURL();
            }
            else if (users.size() > 2){
                int urlsAmount = 0;
                int targetAmount = users.size() == 3 ? 2 : 3;

                for (BUser user : users){
                    if (!user.getEntityID().equals(curUserEntity))
                    {
                        // Skip users that does not have thumbnail url
                        if (StringUtils.isBlank(user.getThumbnailPictureURL()))
                            continue;

                        urlsAmount++;

                        url += user.getThumbnailPictureURL() + (urlsAmount == targetAmount ? "" : ",");

                        if (urlsAmount == targetAmount)
                            break;
                    }
                }
            }
        }

        // If the thumbnail is null.
        if (url == null)
            url = "";

        return url;
    }

    public String displayName(){
        return displayName(getUsers());
    }

    public String displayName(List<BUser> users){

        if (StringUtils.isNotEmpty(name))
            return name;

        if (type == null)
            return "No name available...";

        if (BNetworkManager.getCoreInterface() == null)
            return "No name available...";

        // Due to the data printing when the app run on debug this sometime is null.
        BUser curUser = BNetworkManager.getCoreInterface().currentUserModel();

        if (type != Type.Public){
            String name = "";

            for (BUser user : getUsers()){
                if (!user.getId().equals(curUser.getId()))
                {
                    String n = user.getMetaName();

                    if (StringUtils.isNotEmpty(n)) {
                        name += (!name.equals("") ? ", " : "") + n;
                    }
                }
            }

            return name;
        }
        else if (type == BThreadEntity.Type.Public)
            return name;

        return "No name available...";
    }

    public Date lastMessageAdded(){
        Date date = creationDate;

        List<BMessage> list =getMessagesWithOrder(DaoCore.ORDER_DESC);

        if (list.size() > 0)
            date = list.get(0).getDate();

        if (date == null)
            date = new Date();

        return date;
    }

    /** Fetch messages list from the db for current thread, Messages will be order Desc/Asc on demand.*/
    public List<BMessage> getMessagesWithOrder(int order){
        return getMessagesWithOrder(order, -1);
    }

    /** Fetch messages list from the db for current thread, Messages will be order Desc/Asc on demand.*/
    public List<BMessage> getMessagesWithOrder(int order, int limit){

        List<BMessage> list ;/*= DaoCore.fetchEntitiesWithProperty(BMessage.class, BMessageDao.Properties.OwnerThread, getId());*/

        QueryBuilder<BMessage> qb = daoSession.queryBuilder(BMessage.class);
        qb.where(BMessageDao.Properties.ThreadDaoId.eq(getId()));

        // Making sure no null messages infected the sort.
        qb.where(BMessageDao.Properties.Date.isNotNull());

        if (limit != -1)
            qb.limit(limit);

        list = qb.list();

        Collections.sort(list, new MessageSorter(order));

        return list;
    }

    public boolean hasUser(BUser user){

        com.braunster.chatsdk.dao.UserThreadLink data =
                DaoCore.fetchEntityWithProperties(com.braunster.chatsdk.dao.UserThreadLink.class,
                        new Property[]{UserThreadLinkDao.Properties.BThreadDaoId, UserThreadLinkDao.Properties.BUserDaoId}, getId(), user.getId());

/*        for (BUser u : getUsers())
        {
            if (u.getId().longValue() ==  user.getId().longValue())
               return true;
        }*/

        return data != null;
    }

    public int getUnreadMessagesAmount(){
        int count = 0;
        List<BMessage> messages = getMessagesWithOrder(DaoCore.ORDER_DESC);
        for (BMessage m : messages)
        {
            if(!m.wasRead())
                count++;
            else break;
        }

        return count;
    }

    public boolean isLastMessageWasRead(){
        List<BMessage> messages = getMessagesWithOrder(DaoCore.ORDER_DESC);
        return messages == null || messages.size() == 0 || getMessagesWithOrder(DaoCore.ORDER_DESC).get(0).wasRead();
    }



    public boolean isDeleted(){
        return deleted != null && deleted;
    }

    /**
     * Return the thread type but in a safe way,
     * If thread type is null {@link Type#Public} will be returned.
     * */
    public int getTypeSafely(){
        return type == null ? Type.Public : type;
    }
    // KEEP METHODS END

}
