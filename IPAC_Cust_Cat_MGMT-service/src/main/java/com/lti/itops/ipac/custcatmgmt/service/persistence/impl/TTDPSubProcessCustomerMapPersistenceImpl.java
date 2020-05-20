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

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapImpl;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSubProcessCustomerMapModelImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSubProcessCustomerMapPersistence;

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
 * The persistence implementation for the ttdp sub process customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDPSubProcessCustomerMapPersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSubProcessCustomerMapUtil
 * @generated
 */
@ProviderType
public class TTDPSubProcessCustomerMapPersistenceImpl
	extends BasePersistenceImpl<TTDPSubProcessCustomerMap>
	implements TTDPSubProcessCustomerMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTDPSubProcessCustomerMapUtil} to access the ttdp sub process customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTDPSubProcessCustomerMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByorganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByorganizationId",
			new String[] { Long.class.getName() },
			TTDPSubProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByorganizationId", new String[] { Long.class.getName() });

	/**
	 * Returns all the ttdp sub process customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId) {
		return findByorganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdp sub process customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttdp sub process customer maps
	 * @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	 * @return the range of matching ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end) {
		return findByorganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttdp sub process customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttdp sub process customer maps
	 * @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		return findByorganizationId(organizationId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdp sub process customer maps where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of ttdp sub process customer maps
	 * @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findByorganizationId(
		long organizationId, int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator,
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

		List<TTDPSubProcessCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSubProcessCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap : list) {
					if ((organizationId != ttdpSubProcessCustomerMap.getOrganizationId())) {
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

			query.append(_SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTDPSubProcessCustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<TTDPSubProcessCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSubProcessCustomerMap>)QueryUtil.list(q,
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
	 * Returns the first ttdp sub process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap findByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = fetchByorganizationId_First(organizationId,
				orderByComparator);

		if (ttdpSubProcessCustomerMap != null) {
			return ttdpSubProcessCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDPSubProcessCustomerMapException(msg.toString());
	}

	/**
	 * Returns the first ttdp sub process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByorganizationId_First(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		List<TTDPSubProcessCustomerMap> list = findByorganizationId(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ttdp sub process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap findByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = fetchByorganizationId_Last(organizationId,
				orderByComparator);

		if (ttdpSubProcessCustomerMap != null) {
			return ttdpSubProcessCustomerMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append("}");

		throw new NoSuchTTDPSubProcessCustomerMapException(msg.toString());
	}

	/**
	 * Returns the last ttdp sub process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByorganizationId_Last(
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		int count = countByorganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<TTDPSubProcessCustomerMap> list = findByorganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ttdp sub process customer maps before and after the current ttdp sub process customer map in the ordered set where organizationId = &#63;.
	 *
	 * @param TTDPSubProcessCustomerId the primary key of the current ttdp sub process customer map
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap[] findByorganizationId_PrevAndNext(
		long TTDPSubProcessCustomerId, long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = findByPrimaryKey(TTDPSubProcessCustomerId);

		Session session = null;

		try {
			session = openSession();

			TTDPSubProcessCustomerMap[] array = new TTDPSubProcessCustomerMapImpl[3];

			array[0] = getByorganizationId_PrevAndNext(session,
					ttdpSubProcessCustomerMap, organizationId,
					orderByComparator, true);

			array[1] = ttdpSubProcessCustomerMap;

			array[2] = getByorganizationId_PrevAndNext(session,
					ttdpSubProcessCustomerMap, organizationId,
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

	protected TTDPSubProcessCustomerMap getByorganizationId_PrevAndNext(
		Session session, TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap,
		long organizationId,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator,
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

		query.append(_SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

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
			query.append(TTDPSubProcessCustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ttdpSubProcessCustomerMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTDPSubProcessCustomerMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ttdp sub process customer maps where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 */
	@Override
	public void removeByorganizationId(long organizationId) {
		for (TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap : findByorganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ttdpSubProcessCustomerMap);
		}
	}

	/**
	 * Returns the number of ttdp sub process customer maps where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching ttdp sub process customer maps
	 */
	@Override
	public int countByorganizationId(long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "ttdpSubProcessCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDPSubProcessId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDPSubProcessCustomerMapModelImpl.TTDPSUBPROCESSID_COLUMN_BITMASK |
			TTDPSubProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDPSUBPROCESSID = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDPSubProcessId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param organizationId the organization ID
	 * @return the matching ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap findByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = fetchByTTDPSubProcessId(TTDPSubProcessId,
				organizationId);

		if (ttdpSubProcessCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDPSubProcessId=");
			msg.append(TTDPSubProcessId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDPSubProcessCustomerMapException(msg.toString());
		}

		return ttdpSubProcessCustomerMap;
	}

	/**
	 * Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param organizationId the organization ID
	 * @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId) {
		return fetchByTTDPSubProcessId(TTDPSubProcessId, organizationId, true);
	}

	/**
	 * Returns the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { TTDPSubProcessId, organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID,
					finderArgs, this);
		}

		if (result instanceof TTDPSubProcessCustomerMap) {
			TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)result;

			if ((TTDPSubProcessId != ttdpSubProcessCustomerMap.getTTDPSubProcessId()) ||
					(organizationId != ttdpSubProcessCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSID_TTDPSUBPROCESSID_2);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSubProcessId);

				qPos.add(organizationId);

				List<TTDPSubProcessCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDPSubProcessCustomerMapPersistenceImpl.fetchByTTDPSubProcessId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = list.get(0);

					result = ttdpSubProcessCustomerMap;

					cacheResult(ttdpSubProcessCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID,
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
			return (TTDPSubProcessCustomerMap)result;
		}
	}

	/**
	 * Removes the ttdp sub process customer map where TTDPSubProcessId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param organizationId the organization ID
	 * @return the ttdp sub process customer map that was removed
	 */
	@Override
	public TTDPSubProcessCustomerMap removeByTTDPSubProcessId(
		long TTDPSubProcessId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = findByTTDPSubProcessId(TTDPSubProcessId,
				organizationId);

		return remove(ttdpSubProcessCustomerMap);
	}

	/**
	 * Returns the number of ttdp sub process customer maps where TTDPSubProcessId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param organizationId the organization ID
	 * @return the number of matching ttdp sub process customer maps
	 */
	@Override
	public int countByTTDPSubProcessId(long TTDPSubProcessId,
		long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDPSUBPROCESSID;

		Object[] finderArgs = new Object[] { TTDPSubProcessId, organizationId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSID_TTDPSUBPROCESSID_2);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSubProcessId);

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

	private static final String _FINDER_COLUMN_TTDPSUBPROCESSID_TTDPSUBPROCESSID_2 =
		"ttdpSubProcessCustomerMap.TTDPSubProcessId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPSUBPROCESSID_ORGANIZATIONID_2 =
		"ttdpSubProcessCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID =
		new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDPSubProcessCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			TTDPSubProcessCustomerMapModelImpl.TTDPSUBPROCESSCUSTOMERID_COLUMN_BITMASK |
			TTDPSubProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDPSUBPROCESSCUSTOMERID =
		new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDPSubProcessCustomerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	 *
	 * @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	 * @param organizationId the organization ID
	 * @return the matching ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap findByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = fetchByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
				organizationId);

		if (ttdpSubProcessCustomerMap == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("TTDPSubProcessCustomerId=");
			msg.append(TTDPSubProcessCustomerId);

			msg.append(", organizationId=");
			msg.append(organizationId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDPSubProcessCustomerMapException(msg.toString());
		}

		return ttdpSubProcessCustomerMap;
	}

	/**
	 * Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	 * @param organizationId the organization ID
	 * @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId) {
		return fetchByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
			organizationId, true);
	}

	/**
	 * Returns the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				TTDPSubProcessCustomerId, organizationId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID,
					finderArgs, this);
		}

		if (result instanceof TTDPSubProcessCustomerMap) {
			TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)result;

			if ((TTDPSubProcessCustomerId != ttdpSubProcessCustomerMap.getTTDPSubProcessCustomerId()) ||
					(organizationId != ttdpSubProcessCustomerMap.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSCUSTOMERID_TTDPSUBPROCESSCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSubProcessCustomerId);

				qPos.add(organizationId);

				List<TTDPSubProcessCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDPSubProcessCustomerMapPersistenceImpl.fetchByTTDPSubProcessCustomerId(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = list.get(0);

					result = ttdpSubProcessCustomerMap;

					cacheResult(ttdpSubProcessCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID,
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
			return (TTDPSubProcessCustomerMap)result;
		}
	}

	/**
	 * Removes the ttdp sub process customer map where TTDPSubProcessCustomerId = &#63; and organizationId = &#63; from the database.
	 *
	 * @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	 * @param organizationId the organization ID
	 * @return the ttdp sub process customer map that was removed
	 */
	@Override
	public TTDPSubProcessCustomerMap removeByTTDPSubProcessCustomerId(
		long TTDPSubProcessCustomerId, long organizationId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = findByTTDPSubProcessCustomerId(TTDPSubProcessCustomerId,
				organizationId);

		return remove(ttdpSubProcessCustomerMap);
	}

	/**
	 * Returns the number of ttdp sub process customer maps where TTDPSubProcessCustomerId = &#63; and organizationId = &#63;.
	 *
	 * @param TTDPSubProcessCustomerId the ttdp sub process customer ID
	 * @param organizationId the organization ID
	 * @return the number of matching ttdp sub process customer maps
	 */
	@Override
	public int countByTTDPSubProcessCustomerId(long TTDPSubProcessCustomerId,
		long organizationId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDPSUBPROCESSCUSTOMERID;

		Object[] finderArgs = new Object[] {
				TTDPSubProcessCustomerId, organizationId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSCUSTOMERID_TTDPSUBPROCESSCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSUBPROCESSCUSTOMERID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(TTDPSubProcessCustomerId);

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

	private static final String _FINDER_COLUMN_TTDPSUBPROCESSCUSTOMERID_TTDPSUBPROCESSCUSTOMERID_2 =
		"ttdpSubProcessCustomerMap.TTDPSubProcessCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPSUBPROCESSCUSTOMERID_ORGANIZATIONID_2 =
		"ttdpSubProcessCustomerMap.organizationId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBySubProcessCustomerMap",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TTDPSubProcessCustomerMapModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			TTDPSubProcessCustomerMapModelImpl.TTDPSUBPROCESSID_COLUMN_BITMASK |
			TTDPSubProcessCustomerMapModelImpl.STATUSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBPROCESSCUSTOMERMAP = new FinderPath(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySubProcessCustomerMap",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param statusId the status ID
	 * @return the matching ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap findBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = fetchBySubProcessCustomerMap(organizationId,
				TTDPSubProcessId, statusId);

		if (ttdpSubProcessCustomerMap == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organizationId=");
			msg.append(organizationId);

			msg.append(", TTDPSubProcessId=");
			msg.append(TTDPSubProcessId);

			msg.append(", statusId=");
			msg.append(statusId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDPSubProcessCustomerMapException(msg.toString());
		}

		return ttdpSubProcessCustomerMap;
	}

	/**
	 * Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param statusId the status ID
	 * @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId) {
		return fetchBySubProcessCustomerMap(organizationId, TTDPSubProcessId,
			statusId, true);
	}

	/**
	 * Returns the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param statusId the status ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttdp sub process customer map, or <code>null</code> if a matching ttdp sub process customer map could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				organizationId, TTDPSubProcessId, statusId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP,
					finderArgs, this);
		}

		if (result instanceof TTDPSubProcessCustomerMap) {
			TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)result;

			if ((organizationId != ttdpSubProcessCustomerMap.getOrganizationId()) ||
					(TTDPSubProcessId != ttdpSubProcessCustomerMap.getTTDPSubProcessId()) ||
					(statusId != ttdpSubProcessCustomerMap.getStatusId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_TTDPSUBPROCESSID_2);

			query.append(_FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_STATUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(TTDPSubProcessId);

				qPos.add(statusId);

				List<TTDPSubProcessCustomerMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDPSubProcessCustomerMapPersistenceImpl.fetchBySubProcessCustomerMap(long, long, int, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = list.get(0);

					result = ttdpSubProcessCustomerMap;

					cacheResult(ttdpSubProcessCustomerMap);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP,
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
			return (TTDPSubProcessCustomerMap)result;
		}
	}

	/**
	 * Removes the ttdp sub process customer map where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param statusId the status ID
	 * @return the ttdp sub process customer map that was removed
	 */
	@Override
	public TTDPSubProcessCustomerMap removeBySubProcessCustomerMap(
		long organizationId, long TTDPSubProcessId, int statusId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = findBySubProcessCustomerMap(organizationId,
				TTDPSubProcessId, statusId);

		return remove(ttdpSubProcessCustomerMap);
	}

	/**
	 * Returns the number of ttdp sub process customer maps where organizationId = &#63; and TTDPSubProcessId = &#63; and statusId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param TTDPSubProcessId the ttdp sub process ID
	 * @param statusId the status ID
	 * @return the number of matching ttdp sub process customer maps
	 */
	@Override
	public int countBySubProcessCustomerMap(long organizationId,
		long TTDPSubProcessId, int statusId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBPROCESSCUSTOMERMAP;

		Object[] finderArgs = new Object[] {
				organizationId, TTDPSubProcessId, statusId
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TTDPSUBPROCESSCUSTOMERMAP_WHERE);

			query.append(_FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_TTDPSUBPROCESSID_2);

			query.append(_FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_STATUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(TTDPSubProcessId);

				qPos.add(statusId);

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

	private static final String _FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_ORGANIZATIONID_2 =
		"ttdpSubProcessCustomerMap.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_TTDPSUBPROCESSID_2 =
		"ttdpSubProcessCustomerMap.TTDPSubProcessId = ? AND ";
	private static final String _FINDER_COLUMN_SUBPROCESSCUSTOMERMAP_STATUSID_2 = "ttdpSubProcessCustomerMap.statusId = ?";

	public TTDPSubProcessCustomerMapPersistenceImpl() {
		setModelClass(TTDPSubProcessCustomerMap.class);
	}

	/**
	 * Caches the ttdp sub process customer map in the entity cache if it is enabled.
	 *
	 * @param ttdpSubProcessCustomerMap the ttdp sub process customer map
	 */
	@Override
	public void cacheResult(TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		entityCache.putResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class,
			ttdpSubProcessCustomerMap.getPrimaryKey(), ttdpSubProcessCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID,
			new Object[] {
				ttdpSubProcessCustomerMap.getTTDPSubProcessId(),
				ttdpSubProcessCustomerMap.getOrganizationId()
			}, ttdpSubProcessCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID,
			new Object[] {
				ttdpSubProcessCustomerMap.getTTDPSubProcessCustomerId(),
				ttdpSubProcessCustomerMap.getOrganizationId()
			}, ttdpSubProcessCustomerMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP,
			new Object[] {
				ttdpSubProcessCustomerMap.getOrganizationId(),
				ttdpSubProcessCustomerMap.getTTDPSubProcessId(),
				ttdpSubProcessCustomerMap.getStatusId()
			}, ttdpSubProcessCustomerMap);

		ttdpSubProcessCustomerMap.resetOriginalValues();
	}

	/**
	 * Caches the ttdp sub process customer maps in the entity cache if it is enabled.
	 *
	 * @param ttdpSubProcessCustomerMaps the ttdp sub process customer maps
	 */
	@Override
	public void cacheResult(
		List<TTDPSubProcessCustomerMap> ttdpSubProcessCustomerMaps) {
		for (TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap : ttdpSubProcessCustomerMaps) {
			if (entityCache.getResult(
						TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDPSubProcessCustomerMapImpl.class,
						ttdpSubProcessCustomerMap.getPrimaryKey()) == null) {
				cacheResult(ttdpSubProcessCustomerMap);
			}
			else {
				ttdpSubProcessCustomerMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ttdp sub process customer maps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TTDPSubProcessCustomerMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ttdp sub process customer map.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		entityCache.removeResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class,
			ttdpSubProcessCustomerMap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TTDPSubProcessCustomerMapModelImpl)ttdpSubProcessCustomerMap,
			true);
	}

	@Override
	public void clearCache(
		List<TTDPSubProcessCustomerMap> ttdpSubProcessCustomerMaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap : ttdpSubProcessCustomerMaps) {
			entityCache.removeResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDPSubProcessCustomerMapImpl.class,
				ttdpSubProcessCustomerMap.getPrimaryKey());

			clearUniqueFindersCache((TTDPSubProcessCustomerMapModelImpl)ttdpSubProcessCustomerMap,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TTDPSubProcessCustomerMapModelImpl ttdpSubProcessCustomerMapModelImpl) {
		Object[] args = new Object[] {
				ttdpSubProcessCustomerMapModelImpl.getTTDPSubProcessId(),
				ttdpSubProcessCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDPSUBPROCESSID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID, args,
			ttdpSubProcessCustomerMapModelImpl, false);

		args = new Object[] {
				ttdpSubProcessCustomerMapModelImpl.getTTDPSubProcessCustomerId(),
				ttdpSubProcessCustomerMapModelImpl.getOrganizationId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDPSUBPROCESSCUSTOMERID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID,
			args, ttdpSubProcessCustomerMapModelImpl, false);

		args = new Object[] {
				ttdpSubProcessCustomerMapModelImpl.getOrganizationId(),
				ttdpSubProcessCustomerMapModelImpl.getTTDPSubProcessId(),
				ttdpSubProcessCustomerMapModelImpl.getStatusId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_SUBPROCESSCUSTOMERMAP, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP, args,
			ttdpSubProcessCustomerMapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TTDPSubProcessCustomerMapModelImpl ttdpSubProcessCustomerMapModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdpSubProcessCustomerMapModelImpl.getTTDPSubProcessId(),
					ttdpSubProcessCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSUBPROCESSID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID, args);
		}

		if ((ttdpSubProcessCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdpSubProcessCustomerMapModelImpl.getOriginalTTDPSubProcessId(),
					ttdpSubProcessCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSUBPROCESSID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdpSubProcessCustomerMapModelImpl.getTTDPSubProcessCustomerId(),
					ttdpSubProcessCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSUBPROCESSCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID,
				args);
		}

		if ((ttdpSubProcessCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdpSubProcessCustomerMapModelImpl.getOriginalTTDPSubProcessCustomerId(),
					ttdpSubProcessCustomerMapModelImpl.getOriginalOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSUBPROCESSCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSUBPROCESSCUSTOMERID,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdpSubProcessCustomerMapModelImpl.getOrganizationId(),
					ttdpSubProcessCustomerMapModelImpl.getTTDPSubProcessId(),
					ttdpSubProcessCustomerMapModelImpl.getStatusId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SUBPROCESSCUSTOMERMAP,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP,
				args);
		}

		if ((ttdpSubProcessCustomerMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdpSubProcessCustomerMapModelImpl.getOriginalOrganizationId(),
					ttdpSubProcessCustomerMapModelImpl.getOriginalTTDPSubProcessId(),
					ttdpSubProcessCustomerMapModelImpl.getOriginalStatusId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SUBPROCESSCUSTOMERMAP,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SUBPROCESSCUSTOMERMAP,
				args);
		}
	}

	/**
	 * Creates a new ttdp sub process customer map with the primary key. Does not add the ttdp sub process customer map to the database.
	 *
	 * @param TTDPSubProcessCustomerId the primary key for the new ttdp sub process customer map
	 * @return the new ttdp sub process customer map
	 */
	@Override
	public TTDPSubProcessCustomerMap create(long TTDPSubProcessCustomerId) {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = new TTDPSubProcessCustomerMapImpl();

		ttdpSubProcessCustomerMap.setNew(true);
		ttdpSubProcessCustomerMap.setPrimaryKey(TTDPSubProcessCustomerId);

		ttdpSubProcessCustomerMap.setCompanyId(companyProvider.getCompanyId());

		return ttdpSubProcessCustomerMap;
	}

	/**
	 * Removes the ttdp sub process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	 * @return the ttdp sub process customer map that was removed
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap remove(long TTDPSubProcessCustomerId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		return remove((Serializable)TTDPSubProcessCustomerId);
	}

	/**
	 * Removes the ttdp sub process customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ttdp sub process customer map
	 * @return the ttdp sub process customer map that was removed
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap remove(Serializable primaryKey)
		throws NoSuchTTDPSubProcessCustomerMapException {
		Session session = null;

		try {
			session = openSession();

			TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)session.get(TTDPSubProcessCustomerMapImpl.class,
					primaryKey);

			if (ttdpSubProcessCustomerMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTDPSubProcessCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ttdpSubProcessCustomerMap);
		}
		catch (NoSuchTTDPSubProcessCustomerMapException nsee) {
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
	protected TTDPSubProcessCustomerMap removeImpl(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ttdpSubProcessCustomerMap)) {
				ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)session.get(TTDPSubProcessCustomerMapImpl.class,
						ttdpSubProcessCustomerMap.getPrimaryKeyObj());
			}

			if (ttdpSubProcessCustomerMap != null) {
				session.delete(ttdpSubProcessCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ttdpSubProcessCustomerMap != null) {
			clearCache(ttdpSubProcessCustomerMap);
		}

		return ttdpSubProcessCustomerMap;
	}

	@Override
	public TTDPSubProcessCustomerMap updateImpl(
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap) {
		boolean isNew = ttdpSubProcessCustomerMap.isNew();

		if (!(ttdpSubProcessCustomerMap instanceof TTDPSubProcessCustomerMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ttdpSubProcessCustomerMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ttdpSubProcessCustomerMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ttdpSubProcessCustomerMap proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TTDPSubProcessCustomerMap implementation " +
				ttdpSubProcessCustomerMap.getClass());
		}

		TTDPSubProcessCustomerMapModelImpl ttdpSubProcessCustomerMapModelImpl = (TTDPSubProcessCustomerMapModelImpl)ttdpSubProcessCustomerMap;

		Session session = null;

		try {
			session = openSession();

			if (ttdpSubProcessCustomerMap.isNew()) {
				session.save(ttdpSubProcessCustomerMap);

				ttdpSubProcessCustomerMap.setNew(false);
			}
			else {
				ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)session.merge(ttdpSubProcessCustomerMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TTDPSubProcessCustomerMapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					ttdpSubProcessCustomerMapModelImpl.getOrganizationId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((ttdpSubProcessCustomerMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ttdpSubProcessCustomerMapModelImpl.getOriginalOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] {
						ttdpSubProcessCustomerMapModelImpl.getOrganizationId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		entityCache.putResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSubProcessCustomerMapImpl.class,
			ttdpSubProcessCustomerMap.getPrimaryKey(),
			ttdpSubProcessCustomerMap, false);

		clearUniqueFindersCache(ttdpSubProcessCustomerMapModelImpl, false);
		cacheUniqueFindersCache(ttdpSubProcessCustomerMapModelImpl);

		ttdpSubProcessCustomerMap.resetOriginalValues();

		return ttdpSubProcessCustomerMap;
	}

	/**
	 * Returns the ttdp sub process customer map with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttdp sub process customer map
	 * @return the ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTTDPSubProcessCustomerMapException {
		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = fetchByPrimaryKey(primaryKey);

		if (ttdpSubProcessCustomerMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTTDPSubProcessCustomerMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ttdpSubProcessCustomerMap;
	}

	/**
	 * Returns the ttdp sub process customer map with the primary key or throws a {@link NoSuchTTDPSubProcessCustomerMapException} if it could not be found.
	 *
	 * @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	 * @return the ttdp sub process customer map
	 * @throws NoSuchTTDPSubProcessCustomerMapException if a ttdp sub process customer map with the primary key could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap findByPrimaryKey(
		long TTDPSubProcessCustomerId)
		throws NoSuchTTDPSubProcessCustomerMapException {
		return findByPrimaryKey((Serializable)TTDPSubProcessCustomerId);
	}

	/**
	 * Returns the ttdp sub process customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttdp sub process customer map
	 * @return the ttdp sub process customer map, or <code>null</code> if a ttdp sub process customer map with the primary key could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
				TTDPSubProcessCustomerMapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)serializable;

		if (ttdpSubProcessCustomerMap == null) {
			Session session = null;

			try {
				session = openSession();

				ttdpSubProcessCustomerMap = (TTDPSubProcessCustomerMap)session.get(TTDPSubProcessCustomerMapImpl.class,
						primaryKey);

				if (ttdpSubProcessCustomerMap != null) {
					cacheResult(ttdpSubProcessCustomerMap);
				}
				else {
					entityCache.putResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
						TTDPSubProcessCustomerMapImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSubProcessCustomerMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ttdpSubProcessCustomerMap;
	}

	/**
	 * Returns the ttdp sub process customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param TTDPSubProcessCustomerId the primary key of the ttdp sub process customer map
	 * @return the ttdp sub process customer map, or <code>null</code> if a ttdp sub process customer map with the primary key could not be found
	 */
	@Override
	public TTDPSubProcessCustomerMap fetchByPrimaryKey(
		long TTDPSubProcessCustomerId) {
		return fetchByPrimaryKey((Serializable)TTDPSubProcessCustomerId);
	}

	@Override
	public Map<Serializable, TTDPSubProcessCustomerMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TTDPSubProcessCustomerMap> map = new HashMap<Serializable, TTDPSubProcessCustomerMap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap = fetchByPrimaryKey(primaryKey);

			if (ttdpSubProcessCustomerMap != null) {
				map.put(primaryKey, ttdpSubProcessCustomerMap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSubProcessCustomerMapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TTDPSubProcessCustomerMap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE_PKS_IN);

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

			for (TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap : (List<TTDPSubProcessCustomerMap>)q.list()) {
				map.put(ttdpSubProcessCustomerMap.getPrimaryKeyObj(),
					ttdpSubProcessCustomerMap);

				cacheResult(ttdpSubProcessCustomerMap);

				uncachedPrimaryKeys.remove(ttdpSubProcessCustomerMap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TTDPSubProcessCustomerMapModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSubProcessCustomerMapImpl.class, primaryKey, nullModel);
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
	 * Returns all the ttdp sub process customer maps.
	 *
	 * @return the ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdp sub process customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdp sub process customer maps
	 * @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	 * @return the range of ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttdp sub process customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdp sub process customer maps
	 * @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdp sub process customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSubProcessCustomerMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdp sub process customer maps
	 * @param end the upper bound of the range of ttdp sub process customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ttdp sub process customer maps
	 */
	@Override
	public List<TTDPSubProcessCustomerMap> findAll(int start, int end,
		OrderByComparator<TTDPSubProcessCustomerMap> orderByComparator,
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

		List<TTDPSubProcessCustomerMap> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSubProcessCustomerMap>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP;

				if (pagination) {
					sql = sql.concat(TTDPSubProcessCustomerMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TTDPSubProcessCustomerMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSubProcessCustomerMap>)QueryUtil.list(q,
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
	 * Removes all the ttdp sub process customer maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap : findAll()) {
			remove(ttdpSubProcessCustomerMap);
		}
	}

	/**
	 * Returns the number of ttdp sub process customer maps.
	 *
	 * @return the number of ttdp sub process customer maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTDPSUBPROCESSCUSTOMERMAP);

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
		return TTDPSubProcessCustomerMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ttdp sub process customer map persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TTDPSubProcessCustomerMapImpl.class.getName());
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
	private static final String _SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP = "SELECT ttdpSubProcessCustomerMap FROM TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap";
	private static final String _SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE_PKS_IN =
		"SELECT ttdpSubProcessCustomerMap FROM TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap WHERE TTDPSubProcessCustomerId IN (";
	private static final String _SQL_SELECT_TTDPSUBPROCESSCUSTOMERMAP_WHERE = "SELECT ttdpSubProcessCustomerMap FROM TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap WHERE ";
	private static final String _SQL_COUNT_TTDPSUBPROCESSCUSTOMERMAP = "SELECT COUNT(ttdpSubProcessCustomerMap) FROM TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap";
	private static final String _SQL_COUNT_TTDPSUBPROCESSCUSTOMERMAP_WHERE = "SELECT COUNT(ttdpSubProcessCustomerMap) FROM TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ttdpSubProcessCustomerMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTDPSubProcessCustomerMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTDPSubProcessCustomerMap exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TTDPSubProcessCustomerMapPersistenceImpl.class);
}