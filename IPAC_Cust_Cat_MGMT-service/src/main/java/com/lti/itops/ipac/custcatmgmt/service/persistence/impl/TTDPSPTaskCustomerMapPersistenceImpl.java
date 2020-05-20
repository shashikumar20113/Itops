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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPTaskCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapImpl;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPTaskCustomerMapModelImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSPTaskCustomerMapPersistence;

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
 * The persistence implementation for the ttdpsp task customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPTaskCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSPTaskCustomerMapUtil
 * @generated
 */
@ProviderType
public class TTDPSPTaskCustomerMapPersistenceImpl extends BasePersistenceImpl<TTDPSPTaskCustomerMap>
	implements TTDPSPTaskCustomerMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTDPSPTaskCustomerMapUtil} to access the ttdpsp task customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTDPSPTaskCustomerMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganizationId",
			new String[] { Long.class.getName() },
			TTDPSPTaskCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByorganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ttdpsp task customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorganizationId(long organizationId) {
		return findByorganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdpsp task customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @return the range of matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return findByorganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return findByorganizationId(organizationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
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

		List<TTDPSPTaskCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSPTaskCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : list) {
					if ((organizationId != ttdpspTaskCustomerMap.getOrganizationId())) {
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

			query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTDPSPTaskCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<TTDPSPTaskCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSPTaskCustomerMap>)QueryUtil.list(q,
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
	 * Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByorganizationId_First(organizationId,
				orderByComparator);

		if (ttdpspTaskCustomerMap != null) {
			return ttdpspTaskCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDPSPTaskCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		List<TTDPSPTaskCustomerMap> list = findByorganizationId(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByorganizationId_Last(organizationId,
				orderByComparator);

		if (ttdpspTaskCustomerMap != null) {
			return ttdpspTaskCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDPSPTaskCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		int count = countByorganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<TTDPSPTaskCustomerMap> list = findByorganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ttdpsp task customer maps before and after the current ttdpsp task customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param TTDPSPTaskCustomerId the primary key of the current ttdpsp task customer map
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDPSPTaskCustomerId, long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = findByPrimaryKey(TTDPSPTaskCustomerId);

		Session session = null;

		try {
			session = openSession();

			TTDPSPTaskCustomerMap[] array = new TTDPSPTaskCustomerMapImpl[3];

			array[0] = getByorganizationId_PrevAndNext(session,
					ttdpspTaskCustomerMap, organizationId, orderByComparator,
					true);

			array[1] = ttdpspTaskCustomerMap;

			array[2] = getByorganizationId_PrevAndNext(session,
					ttdpspTaskCustomerMap, organizationId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTDPSPTaskCustomerMap getByorganizationId_PrevAndNext(
		Session session, TTDPSPTaskCustomerMap ttdpspTaskCustomerMap,
		long organizationId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
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

		query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE);

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
			query.append(TTDPSPTaskCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ttdpspTaskCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTDPSPTaskCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ttdpsp task customer maps where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByorganizationId(long organizationId) {
		for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : findByorganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ttdpspTaskCustomerMap);
		}
	}

	/**
	 * Returns the number of ttdpsp task customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching ttdpsp task customer maps
	 */
	@Override
	public int countByorganizationId(long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTDPSPTASKCUSTOMERMAP_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "ttdpspTaskCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TASKID = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBytaskId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDPSPTaskCustomerMapModelImpl.TASKID_COLUMN_BITMASK |
			TTDPSPTaskCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TASKID = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytaskId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	 *
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the matching ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findBytaskId(long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchBytaskId(taskId,
				organizationId);

		if (ttdpspTaskCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taskId=");
			msg.append(taskId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDPSPTaskCustomerMapException(msg.toString());
		}

		return ttdpspTaskCustomerMap;
	}

	/**
	 * Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchBytaskId(long taskId, long organizationId) {
		return fetchBytaskId(taskId, organizationId, true);
	}

	/**
	 * Returns the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchBytaskId(long taskId,
		long organizationId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { taskId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TASKID,
					finderArgs, this);
		}

		if (result instanceof TTDPSPTaskCustomerMap) {
			TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)result;

			if ((taskId != ttdpspTaskCustomerMap.getTaskId()) ||
					(organizationId != ttdpspTaskCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TASKID_TASKID_2);

			query.append(_FINDER_COLUMN_TASKID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskId);

				qPos.add(organizationId);

				List<TTDPSPTaskCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TASKID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDPSPTaskCustomerMapPersistenceImpl.fetchBytaskId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = list.get(0);

					result = ttdpspTaskCustomerMap;

					cacheResult(ttdpspTaskCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKID, finderArgs);

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
			return (TTDPSPTaskCustomerMap)result;
		}
	}

	/**
	 * Removes the ttdpsp task customer map where taskId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the ttdpsp task customer map that was removed
	 */
	@Override
	public TTDPSPTaskCustomerMap removeBytaskId(long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = findBytaskId(taskId,
				organizationId);

		return remove(ttdpspTaskCustomerMap);
	}

	/**
	 * Returns the number of ttdpsp task customer maps where taskId = &#63; and organizationId = &#63;.
	 *
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the number of matching ttdpsp task customer maps
	 */
	@Override
	public int countBytaskId(long taskId, long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TASKID;

		Object[] finderArgs = new Object[] { taskId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TASKID_TASKID_2);

			query.append(_FINDER_COLUMN_TASKID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskId);

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

	private static final String _FINDER_COLUMN_TASKID_TASKID_2 = "ttdpspTaskCustomerMap.taskId = ? AND ";
	private static final String _FINDER_COLUMN_TASKID_ORGANIZATIONID_2 = "ttdpspTaskCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDPSPTaskCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDPSPTaskCustomerMapModelImpl.TTDPSPTASKCUSTOMERID_COLUMN_BITMASK |
			TTDPSPTaskCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERID = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDPSPTaskCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	 *
	 * @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	 * @param organizationId the organization ID
	 * @return the matching ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
				organizationId);

		if (ttdpspTaskCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDPSPTaskCustomerId=");
			msg.append(TTDPSPTaskCustomerId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDPSPTaskCustomerMapException(msg.toString());
		}

		return ttdpspTaskCustomerMap;
	}

	/**
	 * Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	 * @param organizationId the organization ID
	 * @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId) {
		return fetchByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
			organizationId, true);
	}

	/**
	 * Returns the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { TTDPSPTaskCustomerId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID,
					finderArgs, this);
		}

		if (result instanceof TTDPSPTaskCustomerMap) {
			TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)result;

			if ((TTDPSPTaskCustomerId != ttdpspTaskCustomerMap.getTTDPSPTaskCustomerId()) ||
					(organizationId != ttdpspTaskCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERID_TTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSPTaskCustomerId);

				qPos.add(organizationId);

				List<TTDPSPTaskCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDPSPTaskCustomerMapPersistenceImpl.fetchByTTDPSPTaskCustomerId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = list.get(0);

					result = ttdpspTaskCustomerMap;

					cacheResult(ttdpspTaskCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID,
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
			return (TTDPSPTaskCustomerMap)result;
		}
	}

	/**
	 * Removes the ttdpsp task customer map where TTDPSPTaskCustomerId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	 * @param organizationId the organization ID
	 * @return the ttdpsp task customer map that was removed
	 */
	@Override
	public TTDPSPTaskCustomerMap removeByTTDPSPTaskCustomerId(
		long TTDPSPTaskCustomerId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = findByTTDPSPTaskCustomerId(TTDPSPTaskCustomerId,
				organizationId);

		return remove(ttdpspTaskCustomerMap);
	}

	/**
	 * Returns the number of ttdpsp task customer maps where TTDPSPTaskCustomerId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDPSPTaskCustomerId the ttdpsp task customer ID
	 * @param organizationId the organization ID
	 * @return the number of matching ttdpsp task customer maps
	 */
	@Override
	public int countByTTDPSPTaskCustomerId(long TTDPSPTaskCustomerId,
		long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERID;

		Object[] finderArgs = new Object[] { TTDPSPTaskCustomerId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERID_TTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSPTaskCustomerId);

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

	private static final String _FINDER_COLUMN_TTDPSPTASKCUSTOMERID_TTDPSPTASKCUSTOMERID_2 =
		"ttdpspTaskCustomerMap.TTDPSPTaskCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPSPTASKCUSTOMERID_ORGANIZATIONID_2 =
		"ttdpspTaskCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGSUBPROCESSID =
		new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorgSubProcessId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGSUBPROCESSID =
		new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorgSubProcessId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDPSPTaskCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			TTDPSPTaskCustomerMapModelImpl.TTDPSUBPROCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGSUBPROCESSID = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByorgSubProcessId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @return the matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId) {
		return findByorgSubProcessId(organizationId, TTDPSubProcessId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @return the range of matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end) {
		return findByorgSubProcessId(organizationId, TTDPSubProcessId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return findByorgSubProcessId(organizationId, TTDPSubProcessId, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findByorgSubProcessId(
		long organizationId, long TTDPSubProcessId, int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGSUBPROCESSID;
			finderArgs = new Object[] { organizationId, TTDPSubProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGSUBPROCESSID;
			finderArgs = new Object[] {
					organizationId, TTDPSubProcessId,
					
					start, end, orderByComparator
				};
		}

		List<TTDPSPTaskCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSPTaskCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : list) {
					if ((organizationId != ttdpspTaskCustomerMap.getOrganizationId()) ||
							(TTDPSubProcessId != ttdpspTaskCustomerMap.getTTDPSubProcessId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGSUBPROCESSID_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGSUBPROCESSID_TTDPSUBPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTDPSPTaskCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(TTDPSubProcessId);

				if (!pagination) {
					list = (List<TTDPSPTaskCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSPTaskCustomerMap>)QueryUtil.list(q,
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
	 * Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByorgSubProcessId_First(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByorgSubProcessId_First(organizationId,
				TTDPSubProcessId, orderByComparator);

		if (ttdpspTaskCustomerMap != null) {
			return ttdpspTaskCustomerMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", TTDPSubProcessId=");
		msg.append(TTDPSubProcessId);

		msg.append("}");

		throw new NoSuchTTDPSPTaskCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByorgSubProcessId_First(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		List<TTDPSPTaskCustomerMap> list = findByorgSubProcessId(organizationId,
				TTDPSubProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByorgSubProcessId_Last(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByorgSubProcessId_Last(organizationId,
				TTDPSubProcessId, orderByComparator);

		if (ttdpspTaskCustomerMap != null) {
			return ttdpspTaskCustomerMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", TTDPSubProcessId=");
		msg.append(TTDPSubProcessId);

		msg.append("}");

		throw new NoSuchTTDPSPTaskCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByorgSubProcessId_Last(
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		int count = countByorgSubProcessId(organizationId, TTDPSubProcessId);

		if (count == 0) {
			return null;
		}

		List<TTDPSPTaskCustomerMap> list = findByorgSubProcessId(organizationId,
				TTDPSubProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ttdpsp task customer maps before and after the current ttdpsp task customer map in the ordered set where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * @param TTDPSPTaskCustomerId the primary key of the current ttdpsp task customer map
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap[] findByorgSubProcessId_PrevAndNext(
		long TTDPSPTaskCustomerId, long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = findByPrimaryKey(TTDPSPTaskCustomerId);

		Session session = null;

		try {
			session = openSession();

			TTDPSPTaskCustomerMap[] array = new TTDPSPTaskCustomerMapImpl[3];

			array[0] = getByorgSubProcessId_PrevAndNext(session,
					ttdpspTaskCustomerMap, organizationId, TTDPSubProcessId,
					orderByComparator, true);

			array[1] = ttdpspTaskCustomerMap;

			array[2] = getByorgSubProcessId_PrevAndNext(session,
					ttdpspTaskCustomerMap, organizationId, TTDPSubProcessId,
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

	protected TTDPSPTaskCustomerMap getByorgSubProcessId_PrevAndNext(
		Session session, TTDPSPTaskCustomerMap ttdpspTaskCustomerMap,
		long organizationId, long TTDPSubProcessId,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE);

		query.append(_FINDER_COLUMN_ORGSUBPROCESSID_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ORGSUBPROCESSID_TTDPSUBPROCESSID_2);

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
			query.append(TTDPSPTaskCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(TTDPSubProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ttdpspTaskCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTDPSPTaskCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 */
	@Override
	public void removeByorgSubProcessId(long organizationId,
		long TTDPSubProcessId) {
		for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : findByorgSubProcessId(
				organizationId, TTDPSubProcessId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ttdpspTaskCustomerMap);
		}
	}

	/**
	 * Returns the number of ttdpsp task customer maps where organizationId = &#63; and TTDPSubProcessId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @return the number of matching ttdpsp task customer maps
	 */
	@Override
	public int countByorgSubProcessId(long organizationId, long TTDPSubProcessId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGSUBPROCESSID;

		Object[] finderArgs = new Object[] { organizationId, TTDPSubProcessId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGSUBPROCESSID_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGSUBPROCESSID_TTDPSUBPROCESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(TTDPSubProcessId);

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

	private static final String _FINDER_COLUMN_ORGSUBPROCESSID_ORGANIZATIONID_2 = "ttdpspTaskCustomerMap.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGSUBPROCESSID_TTDPSUBPROCESSID_2 =
		"ttdpspTaskCustomerMap.TTDPSubProcessId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDPSPTaskCustomerMapBy",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TTDPSPTaskCustomerMapModelImpl.TTDPSUBPROCESSID_COLUMN_BITMASK |
			TTDPSPTaskCustomerMapModelImpl.TASKID_COLUMN_BITMASK |
			TTDPSPTaskCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERMAPBY = new FinderPath(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDPSPTaskCustomerMapBy",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the matching ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByTTDPSPTaskCustomerMapBy(TTDPSubProcessId,
				taskId, organizationId);

		if (ttdpspTaskCustomerMap == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDPSubProcessId=");
			msg.append(TTDPSubProcessId);

			msg.append(", taskId=");
			msg.append(taskId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDPSPTaskCustomerMapException(msg.toString());
		}

		return ttdpspTaskCustomerMap;
	}

	/**
	 * Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId) {
		return fetchByTTDPSPTaskCustomerMapBy(TTDPSubProcessId, taskId,
			organizationId, true);
	}

	/**
	 * Returns the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttdpsp task customer map, or <code>null</code> if a matching ttdpsp task customer map could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				TTDPSubProcessId, taskId, organizationId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY,
					finderArgs, this);
		}

		if (result instanceof TTDPSPTaskCustomerMap) {
			TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)result;

			if ((TTDPSubProcessId != ttdpspTaskCustomerMap.getTTDPSubProcessId()) ||
					(taskId != ttdpspTaskCustomerMap.getTaskId()) ||
					(organizationId != ttdpspTaskCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_TTDPSUBPROCESSID_2);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_TASKID_2);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSubProcessId);

				qPos.add(taskId);

				qPos.add(organizationId);

				List<TTDPSPTaskCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDPSPTaskCustomerMapPersistenceImpl.fetchByTTDPSPTaskCustomerMapBy(long, long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = list.get(0);

					result = ttdpspTaskCustomerMap;

					cacheResult(ttdpspTaskCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY,
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
			return (TTDPSPTaskCustomerMap)result;
		}
	}

	/**
	 * Removes the ttdpsp task customer map where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the ttdpsp task customer map that was removed
	 */
	@Override
	public TTDPSPTaskCustomerMap removeByTTDPSPTaskCustomerMapBy(
		long TTDPSubProcessId, long taskId, long organizationId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = findByTTDPSPTaskCustomerMapBy(TTDPSubProcessId,
				taskId, organizationId);

		return remove(ttdpspTaskCustomerMap);
	}

	/**
	 * Returns the number of ttdpsp task customer maps where TTDPSubProcessId = &#63; and taskId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param taskId the task ID
	 * @param organizationId the organization ID
	 * @return the number of matching ttdpsp task customer maps
	 */
	@Override
	public int countByTTDPSPTaskCustomerMapBy(long TTDPSubProcessId,
		long taskId, long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERMAPBY;

		Object[] finderArgs = new Object[] {
				TTDPSubProcessId, taskId, organizationId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TTDPSPTASKCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_TTDPSUBPROCESSID_2);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_TASKID_2);

			query.append(_FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSubProcessId);

				qPos.add(taskId);

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

	private static final String _FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_TTDPSUBPROCESSID_2 =
		"ttdpspTaskCustomerMap.TTDPSubProcessId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_TASKID_2 = "ttdpspTaskCustomerMap.taskId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPSPTASKCUSTOMERMAPBY_ORGANIZATIONID_2 =
		"ttdpspTaskCustomerMap.organizationId = ?";

	public TTDPSPTaskCustomerMapPersistenceImpl() {
		setModelClass(TTDPSPTaskCustomerMap.class);
	}

	/**
	 * Caches the ttdpsp task customer map in the entity cache if it is enabled.
	 *
	 * @param ttdpspTaskCustomerMap the ttdpsp task customer map
	 */
	@Override
	public void cacheResult(TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		entityCache.putResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			ttdpspTaskCustomerMap.getPrimaryKey(), ttdpspTaskCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TASKID,
			new Object[] {
				ttdpspTaskCustomerMap.getTaskId(),
				ttdpspTaskCustomerMap.getOrganizationId()
			}, ttdpspTaskCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID,
			new Object[] {
				ttdpspTaskCustomerMap.getTTDPSPTaskCustomerId(),
				ttdpspTaskCustomerMap.getOrganizationId()
			}, ttdpspTaskCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY,
			new Object[] {
				ttdpspTaskCustomerMap.getTTDPSubProcessId(),
				ttdpspTaskCustomerMap.getTaskId(),
				ttdpspTaskCustomerMap.getOrganizationId()
			}, ttdpspTaskCustomerMap);

		ttdpspTaskCustomerMap.resetOriginalValues();
	}

	/**
	 * Caches the ttdpsp task customer maps in the entity cache if it is enabled.
	 *
	 * @param ttdpspTaskCustomerMaps the ttdpsp task customer maps
	 */
	@Override
	public void cacheResult(List<TTDPSPTaskCustomerMap> ttdpspTaskCustomerMaps) {
		for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : ttdpspTaskCustomerMaps) {
			if (entityCache.getResult(
						TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDPSPTaskCustomerMapImpl.class,
						ttdpspTaskCustomerMap.getPrimaryKey()) == null) {
				cacheResult(ttdpspTaskCustomerMap);
			}
			else {
				ttdpspTaskCustomerMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ttdpsp task customer maps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TTDPSPTaskCustomerMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ttdpsp task customer map.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		entityCache.removeResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			ttdpspTaskCustomerMap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TTDPSPTaskCustomerMapModelImpl)ttdpspTaskCustomerMap,
			true);
	}

	@Override
	public void clearCache(List<TTDPSPTaskCustomerMap> ttdpspTaskCustomerMaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : ttdpspTaskCustomerMaps) {
			entityCache.removeResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDPSPTaskCustomerMapImpl.class,
				ttdpspTaskCustomerMap.getPrimaryKey());

			clearUniqueFindersCache((TTDPSPTaskCustomerMapModelImpl)ttdpspTaskCustomerMap,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TTDPSPTaskCustomerMapModelImpl ttdpspTaskCustomerMapModelImpl) {
		Object[] args = new Object[] {
				ttdpspTaskCustomerMapModelImpl.getTaskId(),
				ttdpspTaskCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TASKID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TASKID, args,
			ttdpspTaskCustomerMapModelImpl, false);

		args = new Object[] {
				ttdpspTaskCustomerMapModelImpl.getTTDPSPTaskCustomerId(),
				ttdpspTaskCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID, args,
			ttdpspTaskCustomerMapModelImpl, false);

		args = new Object[] {
				ttdpspTaskCustomerMapModelImpl.getTTDPSubProcessId(),
				ttdpspTaskCustomerMapModelImpl.getTaskId(),
				ttdpspTaskCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERMAPBY,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY,
			args, ttdpspTaskCustomerMapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TTDPSPTaskCustomerMapModelImpl ttdpspTaskCustomerMapModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getTaskId(),
					ttdpspTaskCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TASKID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKID, args);
		}

		if ((ttdpspTaskCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TASKID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getOriginalTaskId(),
					ttdpspTaskCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TASKID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TASKID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getTTDPSPTaskCustomerId(),
					ttdpspTaskCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID,
				args);
		}

		if ((ttdpspTaskCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getOriginalTTDPSPTaskCustomerId(),
					ttdpspTaskCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERID,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getTTDPSubProcessId(),
					ttdpspTaskCustomerMapModelImpl.getTaskId(),
					ttdpspTaskCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERMAPBY,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY,
				args);
		}

		if ((ttdpspTaskCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getOriginalTTDPSubProcessId(),
					ttdpspTaskCustomerMapModelImpl.getOriginalTaskId(),
					ttdpspTaskCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSPTASKCUSTOMERMAPBY,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPTASKCUSTOMERMAPBY,
				args);
		}
	}

	/**
	 * Creates a new ttdpsp task customer map with the primary key. Does not add the ttdpsp task customer map to the database.
	 *
	 * @param TTDPSPTaskCustomerId the primary key for the new ttdpsp task customer map
	 * @return the new ttdpsp task customer map
	 */
	@Override
	public TTDPSPTaskCustomerMap create(long TTDPSPTaskCustomerId) {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = new TTDPSPTaskCustomerMapImpl();

		ttdpspTaskCustomerMap.setNew(true);
		ttdpspTaskCustomerMap.setPrimaryKey(TTDPSPTaskCustomerId);

		ttdpspTaskCustomerMap.setCompanyId(companyProvider.getCompanyId());

		return ttdpspTaskCustomerMap;
	}

	/**
	 * Removes the ttdpsp task customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	 * @return the ttdpsp task customer map that was removed
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap remove(long TTDPSPTaskCustomerId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		return remove((Serializable)TTDPSPTaskCustomerId);
	}

	/**
	 * Removes the ttdpsp task customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ttdpsp task customer map
	 * @return the ttdpsp task customer map that was removed
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap remove(Serializable primaryKey)
		throws NoSuchTTDPSPTaskCustomerMapException {
		Session session = null;

		try {
			session = openSession();

			TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)session.get(TTDPSPTaskCustomerMapImpl.class,
					primaryKey);

			if (ttdpspTaskCustomerMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTDPSPTaskCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ttdpspTaskCustomerMap);
		}
		catch (NoSuchTTDPSPTaskCustomerMapException nsee) {
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
	protected TTDPSPTaskCustomerMap removeImpl(
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ttdpspTaskCustomerMap)) {
				ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)session.get(TTDPSPTaskCustomerMapImpl.class,
						ttdpspTaskCustomerMap.getPrimaryKeyObj());
			}

			if (ttdpspTaskCustomerMap != null) {
				session.delete(ttdpspTaskCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ttdpspTaskCustomerMap != null) {
			clearCache(ttdpspTaskCustomerMap);
		}

		return ttdpspTaskCustomerMap;
	}

	@Override
	public TTDPSPTaskCustomerMap updateImpl(
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap) {
		boolean isNew = ttdpspTaskCustomerMap.isNew();

		if (!(ttdpspTaskCustomerMap instanceof TTDPSPTaskCustomerMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ttdpspTaskCustomerMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ttdpspTaskCustomerMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ttdpspTaskCustomerMap proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TTDPSPTaskCustomerMap implementation " +
				ttdpspTaskCustomerMap.getClass());
		}

		TTDPSPTaskCustomerMapModelImpl ttdpspTaskCustomerMapModelImpl = (TTDPSPTaskCustomerMapModelImpl)ttdpspTaskCustomerMap;

		Session session = null;

		try {
			session = openSession();

			if (ttdpspTaskCustomerMap.isNew()) {
				session.save(ttdpspTaskCustomerMap);

				ttdpspTaskCustomerMap.setNew(false);
			}
			else {
				ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)session.merge(ttdpspTaskCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TTDPSPTaskCustomerMapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
				args);

			args = new Object[] {
					ttdpspTaskCustomerMapModelImpl.getOrganizationId(),
					ttdpspTaskCustomerMapModelImpl.getTTDPSubProcessId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGSUBPROCESSID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGSUBPROCESSID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((ttdpspTaskCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ttdpspTaskCustomerMapModelImpl.getOriginalOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						ttdpspTaskCustomerMapModelImpl.getOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}

			if ((ttdpspTaskCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGSUBPROCESSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ttdpspTaskCustomerMapModelImpl.getOriginalOrganizationId(),
						ttdpspTaskCustomerMapModelImpl.getOriginalTTDPSubProcessId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGSUBPROCESSID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGSUBPROCESSID,
					args);

				args = new Object[] {
						ttdpspTaskCustomerMapModelImpl.getOrganizationId(),
						ttdpspTaskCustomerMapModelImpl.getTTDPSubProcessId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGSUBPROCESSID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGSUBPROCESSID,
					args);
			}
		}

		entityCache.putResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPTaskCustomerMapImpl.class,
			ttdpspTaskCustomerMap.getPrimaryKey(), ttdpspTaskCustomerMap, false);

		clearUniqueFindersCache(ttdpspTaskCustomerMapModelImpl, false);
		cacheUniqueFindersCache(ttdpspTaskCustomerMapModelImpl);

		ttdpspTaskCustomerMap.resetOriginalValues();

		return ttdpspTaskCustomerMap;
	}

	/**
	 * Returns the ttdpsp task customer map with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttdpsp task customer map
	 * @return the ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTTDPSPTaskCustomerMapException {
		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByPrimaryKey(primaryKey);

		if (ttdpspTaskCustomerMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTTDPSPTaskCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ttdpspTaskCustomerMap;
	}

	/**
	 * Returns the ttdpsp task customer map with the primary key or throws a {@link NoSuchTTDPSPTaskCustomerMapException} if it could not be found.
	 *
	 * @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	 * @return the ttdpsp task customer map
	 * @throws NoSuchTTDPSPTaskCustomerMapException if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap findByPrimaryKey(long TTDPSPTaskCustomerId)
		throws NoSuchTTDPSPTaskCustomerMapException {
		return findByPrimaryKey((Serializable)TTDPSPTaskCustomerId);
	}

	/**
	 * Returns the ttdpsp task customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttdpsp task customer map
	 * @return the ttdpsp task customer map, or <code>null</code> if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDPSPTaskCustomerMapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)serializable;

		if (ttdpspTaskCustomerMap == null) {
			Session session = null;

			try {
				session = openSession();

				ttdpspTaskCustomerMap = (TTDPSPTaskCustomerMap)session.get(TTDPSPTaskCustomerMapImpl.class,
						primaryKey);

				if (ttdpspTaskCustomerMap != null) {
					cacheResult(ttdpspTaskCustomerMap);
				}
				else {
					entityCache.putResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDPSPTaskCustomerMapImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSPTaskCustomerMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ttdpspTaskCustomerMap;
	}

	/**
	 * Returns the ttdpsp task customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param TTDPSPTaskCustomerId the primary key of the ttdpsp task customer map
	 * @return the ttdpsp task customer map, or <code>null</code> if a ttdpsp task customer map with the primary key could not be found
	 */
	@Override
	public TTDPSPTaskCustomerMap fetchByPrimaryKey(long TTDPSPTaskCustomerId) {
		return fetchByPrimaryKey((Serializable)TTDPSPTaskCustomerId);
	}

	@Override
	public Map<Serializable, TTDPSPTaskCustomerMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TTDPSPTaskCustomerMap> map = new HashMap<Serializable, TTDPSPTaskCustomerMap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TTDPSPTaskCustomerMap ttdpspTaskCustomerMap = fetchByPrimaryKey(primaryKey);

			if (ttdpspTaskCustomerMap != null) {
				map.put(primaryKey, ttdpspTaskCustomerMap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSPTaskCustomerMapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TTDPSPTaskCustomerMap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE_PKS_IN);

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

			for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : (List<TTDPSPTaskCustomerMap>)q.list()) {
				map.put(ttdpspTaskCustomerMap.getPrimaryKeyObj(),
					ttdpspTaskCustomerMap);

				cacheResult(ttdpspTaskCustomerMap);

				uncachedPrimaryKeys.remove(ttdpspTaskCustomerMap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TTDPSPTaskCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSPTaskCustomerMapImpl.class, primaryKey, nullModel);
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
	 * Returns all the ttdpsp task customer maps.
	 *
	 * @return the ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdpsp task customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @return the range of ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttdpsp task customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdpsp task customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPTaskCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdpsp task customer maps
	 * @param end the upper bound of the range of ttdpsp task customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ttdpsp task customer maps
	 */
	@Override
	public List<TTDPSPTaskCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSPTaskCustomerMap> orderByComparator,
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

		List<TTDPSPTaskCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSPTaskCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TTDPSPTASKCUSTOMERMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTDPSPTASKCUSTOMERMAP;

				if (pagination) {
					sql = sql.concat(TTDPSPTaskCustomerMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TTDPSPTaskCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSPTaskCustomerMap>)QueryUtil.list(q,
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
	 * Removes all the ttdpsp task customer maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TTDPSPTaskCustomerMap ttdpspTaskCustomerMap : findAll()) {
			remove(ttdpspTaskCustomerMap);
		}
	}

	/**
	 * Returns the number of ttdpsp task customer maps.
	 *
	 * @return the number of ttdpsp task customer maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTDPSPTASKCUSTOMERMAP);

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
		return TTDPSPTaskCustomerMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ttdpsp task customer map persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TTDPSPTaskCustomerMapImpl.class.getName());
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
	private static final String _SQL_SELECT_TTDPSPTASKCUSTOMERMAP = "SELECT ttdpspTaskCustomerMap FROM TTDPSPTaskCustomerMap ttdpspTaskCustomerMap";
	private static final String _SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE_PKS_IN = "SELECT ttdpspTaskCustomerMap FROM TTDPSPTaskCustomerMap ttdpspTaskCustomerMap WHERE TTDPSPTaskCustomerId IN (";
	private static final String _SQL_SELECT_TTDPSPTASKCUSTOMERMAP_WHERE = "SELECT ttdpspTaskCustomerMap FROM TTDPSPTaskCustomerMap ttdpspTaskCustomerMap WHERE ";
	private static final String _SQL_COUNT_TTDPSPTASKCUSTOMERMAP = "SELECT COUNT(ttdpspTaskCustomerMap) FROM TTDPSPTaskCustomerMap ttdpspTaskCustomerMap";
	private static final String _SQL_COUNT_TTDPSPTASKCUSTOMERMAP_WHERE = "SELECT COUNT(ttdpspTaskCustomerMap) FROM TTDPSPTaskCustomerMap ttdpspTaskCustomerMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ttdpspTaskCustomerMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTDPSPTaskCustomerMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTDPSPTaskCustomerMap exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TTDPSPTaskCustomerMapPersistenceImpl.class);
}