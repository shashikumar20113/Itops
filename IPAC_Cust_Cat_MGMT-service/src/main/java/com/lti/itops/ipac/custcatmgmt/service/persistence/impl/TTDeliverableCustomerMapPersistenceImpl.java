/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lti.itops.ipac.custcatmgmt.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDeliverableCustomerMapImpl;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDeliverableCustomerMapModelImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDeliverableCustomerMapPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the tt deliverable customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDeliverableCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.TTDeliverableCustomerMapUtil
 * @generated
 */
@ProviderType
public class TTDeliverableCustomerMapPersistenceImpl extends BasePersistenceImpl<TTDeliverableCustomerMap>
	implements TTDeliverableCustomerMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTDeliverableCustomerMapUtil} to access the tt deliverable customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTDeliverableCustomerMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganizationId",
			new String[] { Long.class.getName() },
			TTDeliverableCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByorganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tt deliverable customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId) {
		return findByorganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tt deliverable customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of tt deliverable customer maps
	 * @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	 * @return the range of matching tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return findByorganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tt deliverable customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of tt deliverable customer maps
	 * @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		return findByorganizationId(organizationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tt deliverable customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of tt deliverable customer maps
	 * @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<TTDeliverableCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDeliverableCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTDeliverableCustomerMap ttDeliverableCustomerMap : list) {
					if ((organizationId != ttDeliverableCustomerMap.getOrganizationId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TTDELIVERABLECUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTDeliverableCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<TTDeliverableCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDeliverableCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first tt deliverable customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tt deliverable customer map
	 * @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = fetchByorganizationId_First(organizationId,
				orderByComparator);

		if (ttDeliverableCustomerMap != null) {
			return ttDeliverableCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDeliverableCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first tt deliverable customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		List<TTDeliverableCustomerMap> list = findByorganizationId(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tt deliverable customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tt deliverable customer map
	 * @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = fetchByorganizationId_Last(organizationId,
				orderByComparator);

		if (ttDeliverableCustomerMap != null) {
			return ttDeliverableCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDeliverableCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last tt deliverable customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		int count = countByorganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<TTDeliverableCustomerMap> list = findByorganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tt deliverable customer maps before and after the current tt deliverable customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param TTDeliverableCustomerId the primary key of the current tt deliverable customer map
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tt deliverable customer map
	 * @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	 */
	@Override
	public TTDeliverableCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDeliverableCustomerId, long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = findByPrimaryKey(TTDeliverableCustomerId);

		Session session = null;

		try {
			session = openSession();

			TTDeliverableCustomerMap[] array = new TTDeliverableCustomerMapImpl[3];

			array[0] = getByorganizationId_PrevAndNext(session,
					ttDeliverableCustomerMap, organizationId,
					orderByComparator, true);

			array[1] = ttDeliverableCustomerMap;

			array[2] = getByorganizationId_PrevAndNext(session,
					ttDeliverableCustomerMap, organizationId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTDeliverableCustomerMap getByorganizationId_PrevAndNext(
		Session session, TTDeliverableCustomerMap ttDeliverableCustomerMap,
		long organizationId,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTDELIVERABLECUSTOMERMAP_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TTDeliverableCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ttDeliverableCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTDeliverableCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tt deliverable customer maps where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByorganizationId(long organizationId) {
		for (TTDeliverableCustomerMap ttDeliverableCustomerMap : findByorganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ttDeliverableCustomerMap);
		}
	}

	/**
	 * Returns the number of tt deliverable customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching tt deliverable customer maps
	 */
	@Override
	public int countByorganizationId(long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTDELIVERABLECUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "ttDeliverableCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDELIVERABLEID = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDeliverableId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDeliverableCustomerMapModelImpl.TTDELIVERABLEID_COLUMN_BITMASK |
			TTDeliverableCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDELIVERABLEID = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDeliverableId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	 *
	 * @param TTDeliverableId the tt deliverable ID
	 * @param organizationId the organization ID
	 * @return the matching tt deliverable customer map
	 * @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap findByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = fetchByTTDeliverableId(TTDeliverableId,
				organizationId);

		if (ttDeliverableCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDeliverableId=");
			msg.append(TTDeliverableId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDeliverableCustomerMapException(msg.toString());
		}

		return ttDeliverableCustomerMap;
	}

	/**
	 * Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDeliverableId the tt deliverable ID
	 * @param organizationId the organization ID
	 * @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByTTDeliverableId(
		long TTDeliverableId, long organizationId) {
		return fetchByTTDeliverableId(TTDeliverableId, organizationId, true);
	}

	/**
	 * Returns the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDeliverableId the tt deliverable ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByTTDeliverableId(
		long TTDeliverableId, long organizationId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { TTDeliverableId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDELIVERABLEID,
					finderArgs, this);
		}

		if (result instanceof TTDeliverableCustomerMap) {
			TTDeliverableCustomerMap ttDeliverableCustomerMap = (TTDeliverableCustomerMap)result;

			if ((TTDeliverableId != ttDeliverableCustomerMap.getTTDeliverableId()) ||
					(organizationId != ttDeliverableCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDELIVERABLECUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDELIVERABLEID_TTDELIVERABLEID_2);

			query.append(_FINDER_COLUMN_TTDELIVERABLEID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDeliverableId);

				qPos.add(organizationId);

				List<TTDeliverableCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDELIVERABLEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDeliverableCustomerMapPersistenceImpl.fetchByTTDeliverableId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDeliverableCustomerMap ttDeliverableCustomerMap = list.get(0);

					result = ttDeliverableCustomerMap;

					cacheResult(ttDeliverableCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDELIVERABLEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTDeliverableCustomerMap)result;
		}
	}

	/**
	 * Removes the tt deliverable customer map where TTDeliverableId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDeliverableId the tt deliverable ID
	 * @param organizationId the organization ID
	 * @return the tt deliverable customer map that was removed
	 */
	@Override
	public TTDeliverableCustomerMap removeByTTDeliverableId(
		long TTDeliverableId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = findByTTDeliverableId(TTDeliverableId,
				organizationId);

		return remove(ttDeliverableCustomerMap);
	}

	/**
	 * Returns the number of tt deliverable customer maps where TTDeliverableId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDeliverableId the tt deliverable ID
	 * @param organizationId the organization ID
	 * @return the number of matching tt deliverable customer maps
	 */
	@Override
	public int countByTTDeliverableId(long TTDeliverableId, long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDELIVERABLEID;

		Object[] finderArgs = new Object[] { TTDeliverableId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDELIVERABLECUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDELIVERABLEID_TTDELIVERABLEID_2);

			query.append(_FINDER_COLUMN_TTDELIVERABLEID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDeliverableId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TTDELIVERABLEID_TTDELIVERABLEID_2 =
		"ttDeliverableCustomerMap.TTDeliverableId = ? AND ";
	private static final String _FINDER_COLUMN_TTDELIVERABLEID_ORGANIZATIONID_2 = "ttDeliverableCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDeliverableCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDeliverableCustomerMapModelImpl.TTDELIVERABLECUSTOMERID_COLUMN_BITMASK |
			TTDeliverableCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDELIVERABLECUSTOMERID = new FinderPath(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDeliverableCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	 *
	 * @param TTDeliverableCustomerId the tt deliverable customer ID
	 * @param organizationId the organization ID
	 * @return the matching tt deliverable customer map
	 * @throws NoSuchTTDeliverableCustomerMapException if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap findByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = fetchByTTDeliverableCustomerId(TTDeliverableCustomerId,
				organizationId);

		if (ttDeliverableCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDeliverableCustomerId=");
			msg.append(TTDeliverableCustomerId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDeliverableCustomerMapException(msg.toString());
		}

		return ttDeliverableCustomerMap;
	}

	/**
	 * Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDeliverableCustomerId the tt deliverable customer ID
	 * @param organizationId the organization ID
	 * @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId) {
		return fetchByTTDeliverableCustomerId(TTDeliverableCustomerId,
			organizationId, true);
	}

	/**
	 * Returns the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDeliverableCustomerId the tt deliverable customer ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching tt deliverable customer map, or <code>null</code> if a matching tt deliverable customer map could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				TTDeliverableCustomerId, organizationId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID,
					finderArgs, this);
		}

		if (result instanceof TTDeliverableCustomerMap) {
			TTDeliverableCustomerMap ttDeliverableCustomerMap = (TTDeliverableCustomerMap)result;

			if ((TTDeliverableCustomerId != ttDeliverableCustomerMap.getTTDeliverableCustomerId()) ||
					(organizationId != ttDeliverableCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDELIVERABLECUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDELIVERABLECUSTOMERID_TTDELIVERABLECUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDELIVERABLECUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDeliverableCustomerId);

				qPos.add(organizationId);

				List<TTDeliverableCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDeliverableCustomerMapPersistenceImpl.fetchByTTDeliverableCustomerId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDeliverableCustomerMap ttDeliverableCustomerMap = list.get(0);

					result = ttDeliverableCustomerMap;

					cacheResult(ttDeliverableCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTDeliverableCustomerMap)result;
		}
	}

	/**
	 * Removes the tt deliverable customer map where TTDeliverableCustomerId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDeliverableCustomerId the tt deliverable customer ID
	 * @param organizationId the organization ID
	 * @return the tt deliverable customer map that was removed
	 */
	@Override
	public TTDeliverableCustomerMap removeByTTDeliverableCustomerId(
		long TTDeliverableCustomerId, long organizationId)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = findByTTDeliverableCustomerId(TTDeliverableCustomerId,
				organizationId);

		return remove(ttDeliverableCustomerMap);
	}

	/**
	 * Returns the number of tt deliverable customer maps where TTDeliverableCustomerId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDeliverableCustomerId the tt deliverable customer ID
	 * @param organizationId the organization ID
	 * @return the number of matching tt deliverable customer maps
	 */
	@Override
	public int countByTTDeliverableCustomerId(long TTDeliverableCustomerId,
		long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDELIVERABLECUSTOMERID;

		Object[] finderArgs = new Object[] {
				TTDeliverableCustomerId, organizationId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDELIVERABLECUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDELIVERABLECUSTOMERID_TTDELIVERABLECUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDELIVERABLECUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDeliverableCustomerId);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TTDELIVERABLECUSTOMERID_TTDELIVERABLECUSTOMERID_2 =
		"ttDeliverableCustomerMap.TTDeliverableCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_TTDELIVERABLECUSTOMERID_ORGANIZATIONID_2 =
		"ttDeliverableCustomerMap.organizationId = ?";

	public TTDeliverableCustomerMapPersistenceImpl() {
		setModelClass(TTDeliverableCustomerMap.class);
	}

	/**
	 * Caches the tt deliverable customer map in the entity cache if it is enabled.
	 *
	 * @param ttDeliverableCustomerMap the tt deliverable customer map
	 */
	@Override
	public void cacheResult(TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		entityCache.putResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class,
			ttDeliverableCustomerMap.getPrimaryKey(), ttDeliverableCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDELIVERABLEID,
			new Object[] {
				ttDeliverableCustomerMap.getTTDeliverableId(),
				ttDeliverableCustomerMap.getOrganizationId()
			}, ttDeliverableCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID,
			new Object[] {
				ttDeliverableCustomerMap.getTTDeliverableCustomerId(),
				ttDeliverableCustomerMap.getOrganizationId()
			}, ttDeliverableCustomerMap);

		ttDeliverableCustomerMap.resetOriginalValues();
	}

	/**
	 * Caches the tt deliverable customer maps in the entity cache if it is enabled.
	 *
	 * @param ttDeliverableCustomerMaps the tt deliverable customer maps
	 */
	@Override
	public void cacheResult(
		List<TTDeliverableCustomerMap> ttDeliverableCustomerMaps) {
		for (TTDeliverableCustomerMap ttDeliverableCustomerMap : ttDeliverableCustomerMaps) {
			if (entityCache.getResult(
						TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDeliverableCustomerMapImpl.class,
						ttDeliverableCustomerMap.getPrimaryKey()) == null) {
				cacheResult(ttDeliverableCustomerMap);
			}
			else {
				ttDeliverableCustomerMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tt deliverable customer maps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TTDeliverableCustomerMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tt deliverable customer map.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		entityCache.removeResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class,
			ttDeliverableCustomerMap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TTDeliverableCustomerMapModelImpl)ttDeliverableCustomerMap,
			true);
	}

	@Override
	public void clearCache(
		List<TTDeliverableCustomerMap> ttDeliverableCustomerMaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTDeliverableCustomerMap ttDeliverableCustomerMap : ttDeliverableCustomerMaps) {
			entityCache.removeResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDeliverableCustomerMapImpl.class,
				ttDeliverableCustomerMap.getPrimaryKey());

			clearUniqueFindersCache((TTDeliverableCustomerMapModelImpl)ttDeliverableCustomerMap,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TTDeliverableCustomerMapModelImpl ttDeliverableCustomerMapModelImpl) {
		Object[] args = new Object[] {
				ttDeliverableCustomerMapModelImpl.getTTDeliverableId(),
				ttDeliverableCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDELIVERABLEID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDELIVERABLEID, args,
			ttDeliverableCustomerMapModelImpl, false);

		args = new Object[] {
				ttDeliverableCustomerMapModelImpl.getTTDeliverableCustomerId(),
				ttDeliverableCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDELIVERABLECUSTOMERID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID,
			args, ttDeliverableCustomerMapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TTDeliverableCustomerMapModelImpl ttDeliverableCustomerMapModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					ttDeliverableCustomerMapModelImpl.getTTDeliverableId(),
					ttDeliverableCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDELIVERABLEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDELIVERABLEID, args);
		}

		if ((ttDeliverableCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDELIVERABLEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttDeliverableCustomerMapModelImpl.getOriginalTTDeliverableId(),
					ttDeliverableCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDELIVERABLEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDELIVERABLEID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					ttDeliverableCustomerMapModelImpl.getTTDeliverableCustomerId(),
					ttDeliverableCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDELIVERABLECUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID,
				args);
		}

		if ((ttDeliverableCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttDeliverableCustomerMapModelImpl.getOriginalTTDeliverableCustomerId(),
					ttDeliverableCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDELIVERABLECUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDELIVERABLECUSTOMERID,
				args);
		}
	}

	/**
	 * Creates a new tt deliverable customer map with the primary key. Does not add the tt deliverable customer map to the database.
	 *
	 * @param TTDeliverableCustomerId the primary key for the new tt deliverable customer map
	 * @return the new tt deliverable customer map
	 */
	@Override
	public TTDeliverableCustomerMap create(long TTDeliverableCustomerId) {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = new TTDeliverableCustomerMapImpl();

		ttDeliverableCustomerMap.setNew(true);
		ttDeliverableCustomerMap.setPrimaryKey(TTDeliverableCustomerId);

		ttDeliverableCustomerMap.setCompanyId(companyProvider.getCompanyId());

		return ttDeliverableCustomerMap;
	}

	/**
	 * Removes the tt deliverable customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	 * @return the tt deliverable customer map that was removed
	 * @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	 */
	@Override
	public TTDeliverableCustomerMap remove(long TTDeliverableCustomerId)
		throws NoSuchTTDeliverableCustomerMapException {
		return remove((Serializable)TTDeliverableCustomerId);
	}

	/**
	 * Removes the tt deliverable customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tt deliverable customer map
	 * @return the tt deliverable customer map that was removed
	 * @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	 */
	@Override
	public TTDeliverableCustomerMap remove(Serializable primaryKey)
		throws NoSuchTTDeliverableCustomerMapException {
		Session session = null;

		try {
			session = openSession();

			TTDeliverableCustomerMap ttDeliverableCustomerMap = (TTDeliverableCustomerMap)session.get(TTDeliverableCustomerMapImpl.class,
					primaryKey);

			if (ttDeliverableCustomerMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTDeliverableCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ttDeliverableCustomerMap);
		}
		catch (NoSuchTTDeliverableCustomerMapException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TTDeliverableCustomerMap removeImpl(
		TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ttDeliverableCustomerMap)) {
				ttDeliverableCustomerMap = (TTDeliverableCustomerMap)session.get(TTDeliverableCustomerMapImpl.class,
						ttDeliverableCustomerMap.getPrimaryKeyObj());
			}

			if (ttDeliverableCustomerMap != null) {
				session.delete(ttDeliverableCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ttDeliverableCustomerMap != null) {
			clearCache(ttDeliverableCustomerMap);
		}

		return ttDeliverableCustomerMap;
	}

	@Override
	public TTDeliverableCustomerMap updateImpl(
		TTDeliverableCustomerMap ttDeliverableCustomerMap) {
		boolean isNew = ttDeliverableCustomerMap.isNew();

		if (!(ttDeliverableCustomerMap instanceof TTDeliverableCustomerMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ttDeliverableCustomerMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ttDeliverableCustomerMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ttDeliverableCustomerMap proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TTDeliverableCustomerMap implementation " +
				ttDeliverableCustomerMap.getClass());
		}

		TTDeliverableCustomerMapModelImpl ttDeliverableCustomerMapModelImpl = (TTDeliverableCustomerMapModelImpl)ttDeliverableCustomerMap;

		Session session = null;

		try {
			session = openSession();

			if (ttDeliverableCustomerMap.isNew()) {
				session.save(ttDeliverableCustomerMap);

				ttDeliverableCustomerMap.setNew(false);
			}
			else {
				ttDeliverableCustomerMap = (TTDeliverableCustomerMap)session.merge(ttDeliverableCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TTDeliverableCustomerMapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					ttDeliverableCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((ttDeliverableCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ttDeliverableCustomerMapModelImpl.getOriginalOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						ttDeliverableCustomerMapModelImpl.getOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		entityCache.putResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDeliverableCustomerMapImpl.class,
			ttDeliverableCustomerMap.getPrimaryKey(), ttDeliverableCustomerMap,
			false);

		clearUniqueFindersCache(ttDeliverableCustomerMapModelImpl, false);
		cacheUniqueFindersCache(ttDeliverableCustomerMapModelImpl);

		ttDeliverableCustomerMap.resetOriginalValues();

		return ttDeliverableCustomerMap;
	}

	/**
	 * Returns the tt deliverable customer map with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tt deliverable customer map
	 * @return the tt deliverable customer map
	 * @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	 */
	@Override
	public TTDeliverableCustomerMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTTDeliverableCustomerMapException {
		TTDeliverableCustomerMap ttDeliverableCustomerMap = fetchByPrimaryKey(primaryKey);

		if (ttDeliverableCustomerMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTTDeliverableCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ttDeliverableCustomerMap;
	}

	/**
	 * Returns the tt deliverable customer map with the primary key or throws a {@link NoSuchTTDeliverableCustomerMapException} if it could not be found.
	 *
	 * @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	 * @return the tt deliverable customer map
	 * @throws NoSuchTTDeliverableCustomerMapException if a tt deliverable customer map with the primary key could not be found
	 */
	@Override
	public TTDeliverableCustomerMap findByPrimaryKey(
		long TTDeliverableCustomerId)
		throws NoSuchTTDeliverableCustomerMapException {
		return findByPrimaryKey((Serializable)TTDeliverableCustomerId);
	}

	/**
	 * Returns the tt deliverable customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tt deliverable customer map
	 * @return the tt deliverable customer map, or <code>null</code> if a tt deliverable customer map with the primary key could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDeliverableCustomerMapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TTDeliverableCustomerMap ttDeliverableCustomerMap = (TTDeliverableCustomerMap)serializable;

		if (ttDeliverableCustomerMap == null) {
			Session session = null;

			try {
				session = openSession();

				ttDeliverableCustomerMap = (TTDeliverableCustomerMap)session.get(TTDeliverableCustomerMapImpl.class,
						primaryKey);

				if (ttDeliverableCustomerMap != null) {
					cacheResult(ttDeliverableCustomerMap);
				}
				else {
					entityCache.putResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDeliverableCustomerMapImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDeliverableCustomerMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ttDeliverableCustomerMap;
	}

	/**
	 * Returns the tt deliverable customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param TTDeliverableCustomerId the primary key of the tt deliverable customer map
	 * @return the tt deliverable customer map, or <code>null</code> if a tt deliverable customer map with the primary key could not be found
	 */
	@Override
	public TTDeliverableCustomerMap fetchByPrimaryKey(
		long TTDeliverableCustomerId) {
		return fetchByPrimaryKey((Serializable)TTDeliverableCustomerId);
	}

	@Override
	public Map<Serializable, TTDeliverableCustomerMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TTDeliverableCustomerMap> map = new HashMap<Serializable, TTDeliverableCustomerMap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TTDeliverableCustomerMap ttDeliverableCustomerMap = fetchByPrimaryKey(primaryKey);

			if (ttDeliverableCustomerMap != null) {
				map.put(primaryKey, ttDeliverableCustomerMap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDeliverableCustomerMapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TTDeliverableCustomerMap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TTDELIVERABLECUSTOMERMAP_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TTDeliverableCustomerMap ttDeliverableCustomerMap : (List<TTDeliverableCustomerMap>)q.list()) {
				map.put(ttDeliverableCustomerMap.getPrimaryKeyObj(),
					ttDeliverableCustomerMap);

				cacheResult(ttDeliverableCustomerMap);

				uncachedPrimaryKeys.remove(ttDeliverableCustomerMap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TTDeliverableCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDeliverableCustomerMapImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the tt deliverable customer maps.
	 *
	 * @return the tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tt deliverable customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tt deliverable customer maps
	 * @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	 * @return the range of tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tt deliverable customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tt deliverable customer maps
	 * @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tt deliverable customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDeliverableCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tt deliverable customer maps
	 * @param end the upper bound of the range of tt deliverable customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of tt deliverable customer maps
	 */
	@Override
	public List<TTDeliverableCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDeliverableCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TTDeliverableCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDeliverableCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TTDELIVERABLECUSTOMERMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTDELIVERABLECUSTOMERMAP;

				if (pagination) {
					sql = sql.concat(TTDeliverableCustomerMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TTDeliverableCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDeliverableCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tt deliverable customer maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TTDeliverableCustomerMap ttDeliverableCustomerMap : findAll()) {
			remove(ttDeliverableCustomerMap);
		}
	}

	/**
	 * Returns the number of tt deliverable customer maps.
	 *
	 * @return the number of tt deliverable customer maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTDELIVERABLECUSTOMERMAP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TTDeliverableCustomerMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tt deliverable customer map persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TTDeliverableCustomerMapImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TTDELIVERABLECUSTOMERMAP = "SELECT ttDeliverableCustomerMap FROM TTDeliverableCustomerMap ttDeliverableCustomerMap";
	private static final String _SQL_SELECT_TTDELIVERABLECUSTOMERMAP_WHERE_PKS_IN =
		"SELECT ttDeliverableCustomerMap FROM TTDeliverableCustomerMap ttDeliverableCustomerMap WHERE TTDeliverableCustomerId IN (";
	private static final String _SQL_SELECT_TTDELIVERABLECUSTOMERMAP_WHERE = "SELECT ttDeliverableCustomerMap FROM TTDeliverableCustomerMap ttDeliverableCustomerMap WHERE ";
	private static final String _SQL_COUNT_TTDELIVERABLECUSTOMERMAP = "SELECT COUNT(ttDeliverableCustomerMap) FROM TTDeliverableCustomerMap ttDeliverableCustomerMap";
	private static final String _SQL_COUNT_TTDELIVERABLECUSTOMERMAP_WHERE = "SELECT COUNT(ttDeliverableCustomerMap) FROM TTDeliverableCustomerMap ttDeliverableCustomerMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ttDeliverableCustomerMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTDeliverableCustomerMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTDeliverableCustomerMap exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TTDeliverableCustomerMapPersistenceImpl.class);
}